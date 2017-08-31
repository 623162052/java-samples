/**
 * Created on 2010-11-9 上午11:37:12
 * Copyright (c) 2010-11-9 Asiainfo Technologies(China),Inc.
 */
package framework.jedis;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Redis访问工具类
 * 
 * @author guyu
 *
 */
public class Redises implements InvocationHandler {

	private static Log log = LogFactory.getLog(Redises.class);

    // "host:120.26.215.167,password:foobared,poolSize:10"
	private static final String DEFAULT_REDIS_POOL_NAME = "host:120.26.215.167,poolSize:50";//"X_REDIS_CS_COMMON";
	
	private static Map<String, RedisPool> pools = null;
	
	// 用于拦截获取redis相关API的执行,使其能够自动归还到连接池
	private static Map<String, InvocationHandler> handlers = null;
	
	private String poolName;	// 用于InvocationHandler的连接池名称
	
	/**
	 * 不可实例化
	 */
	private Redises(String poolName) {
		super();
		this.poolName = poolName;
	}

	/**
	 * 根据pool name获取redis pool对象
	 * @param poolName 池配置名称
	 * @return
	 */
	public static RedisPool getRedisPool(String poolName) {
		// 创建连接池Map
		if (null == pools) {
			synchronized (Redises.class) {
				if (null == pools) {
					pools = new ConcurrentHashMap<String, RedisPool>();
				}
			}
		}
		RedisPool redisPool = pools.get(poolName);
		if (null == redisPool) {
			synchronized (pools) {
				redisPool = pools.get(poolName);
				if (null == redisPool) {
					String host, password;
					int port, poolSize, timeout;
					
					PropertiesConfiguration pc = null;
					try {
						pc = new PropertiesConfiguration("dbinfo.properties");
					} catch (ConfigurationException e) {
						log.error("cannot read properties file(/dbinfo.properties)", e);
					}
					
					if (null == pc) {
						String poolConf = DEFAULT_REDIS_POOL_NAME;//SysManager.getInstance().getParamValue(poolName, "");
						if (poolConf.length() <= 0)
							throw new IllegalArgumentException("illegal redis pool name:" + poolName + ", must not be blank");
						
						host = extract(poolConf, "host");
						port = RedisPool.DEFAULT_PORT_NUM;
						password = extract(poolConf, "password");
						poolSize = RedisPool.DEFAULT_POOL_SIZE;
						timeout = RedisPool.DEFAULT_TIMEOUT;
					} else {
						String tolerantName = DEFAULT_REDIS_POOL_NAME.equalsIgnoreCase(poolName) ? "" : ("." + DEFAULT_REDIS_POOL_NAME);
						host = pc.getString("redis" + tolerantName + ".host");
						port = pc.getInt("redis" + tolerantName + ".port", RedisPool.DEFAULT_PORT_NUM);
						password = pc.getString("redis" + tolerantName + ".password");
						poolSize = pc.getInt("redis" + tolerantName + ".poolSize", RedisPool.DEFAULT_POOL_SIZE);
						timeout = pc.getInt("redis" + tolerantName + ".timeout", RedisPool.DEFAULT_TIMEOUT);
					}

					// 构造并初始化连接池
					redisPool = new RedisPool(host, port, password, poolSize, timeout);
					redisPool.init();
					
					pools.put(poolName, redisPool);
				}
			}
		}
		
		return redisPool;
	}
	
	/**
	 * 从字符串中摘取key值对应的片断
	 * @param str 形如key1:value1,key2:value2,....的字符串
	 * @param key 需要匹配的key
	 * @return key对应的value值
	 */
	private static String extract(String str, String key) {
		int keyIndex = str.indexOf(key);
		int colonIdx = keyIndex + key.length();
		if ((keyIndex >= 0) && (colonIdx < str.length())) {
			int commaIdx = str.indexOf(',', colonIdx);
			if (commaIdx > colonIdx)
				return str.substring(colonIdx + 1, commaIdx);
			else
				return str.substring(colonIdx + 1);
		}
		return null;
	}
	
	/**
	 * 获取redis pool对象
	 * @return
	 */
	public static RedisPool getRedisPool() {
		return getRedisPool(DEFAULT_REDIS_POOL_NAME);
	}
	
	/**
	 * 从指定池中获取redis对象,使用者负责释放
	 * @param poolName 池名称
	 */
	public static Jedis getPooledRedis(String poolName) {
		return getRedisPool(poolName).getRedisFromPool();
	}
	
	/**
	 * 从缺省池中获取redis对象,使用者负责释放
	 */
	public static Jedis getPooledRedis() {
		return getPooledRedis(DEFAULT_REDIS_POOL_NAME);
	}
	
	/**
	 * 返回redis给缺省连接池
	 * @param redis
	 */
	public static void returnToPool(Jedis redis) {
		if (null == redis) {
			return;
		}
		getRedisPool().returnToPool(redis);
	}
	
	/**
	 * 返回redis给指定连接池
	 * @param poolName
	 * @param redis
	 */
	public static void returnToPool(String poolName, Jedis redis) {
		getRedisPool(poolName).returnToPool(redis);
	}

	/**
	 * 从指定池中获取jedis commands对象,使用者无需释放
	 * 一般用于单指令的执行,执行完毕后动态代理负责将jedis对象归还到池中
	 * 当一次需要执行多个指令时,请使用getPooledRedis来获取jedis对象并手工归还
	 * 
	 * @param poolName 池名称
	 * @return
	 */
	public static JedisCommands getPooledJedisCommands(String poolName) {
		if (null == handlers) {
			synchronized (Redises.class) {
				if (null == handlers) {
					handlers = new ConcurrentHashMap<String, InvocationHandler>();
				}
			}
		}
		InvocationHandler invocationHandler = handlers.get(poolName);
		if (null == invocationHandler) {
			synchronized (handlers) {
				invocationHandler = handlers.get(poolName);
				if (null == invocationHandler) {
					invocationHandler = new Redises(poolName);
					handlers.put(poolName, invocationHandler);
				}
			}
		}
		
		return (JedisCommands) Proxy.newProxyInstance(
				JedisCommands.class.getClassLoader(),
				new Class[] { JedisCommands.class }, invocationHandler);
	}
	
	/**
	 * 从缺省池中获取jedis commands对象,使用者无需释放
	 * 一般用于单指令的执行,执行完毕后动态代理负责将jedis对象归还到池中
	 * 当一次需要执行多个指令时,请使用getPooledRedis来获取jedis对象并手工归还
	 * 
	 * @return
	 */
	public static JedisCommands getPooledJedisCommands() {
		return getPooledJedisCommands(DEFAULT_REDIS_POOL_NAME);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.currentTimeMillis();
		
		// 调用入口日志
		if (log.isDebugEnabled()) {
			log.debug("proxy instance of JedisCommands invoked (methodName:" + method.getName() + ", arguments:" + Arrays.toString(args) + ")");
		}
		
		// 从连接池获取redis连接
		Jedis redis = getPooledRedis(this.poolName);
		
		Object rtnRslt = null;
		try {
			rtnRslt = method.invoke(redis, args);
		} finally {
			returnToPool(this.poolName, redis);
		}

		if (log.isInfoEnabled()) {
			log.info("excecute JedisCommands " + method.getName() + "(" + Arrays.toString(args) + ") elapsed time:" + (System.currentTimeMillis() - start) + " ms!");
		}
		
		return rtnRslt;
	}
	
}
