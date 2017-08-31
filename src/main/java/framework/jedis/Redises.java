/**
 * Created on 2010-11-9 ����11:37:12
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
 * Redis���ʹ�����
 * 
 * @author guyu
 *
 */
public class Redises implements InvocationHandler {

	private static Log log = LogFactory.getLog(Redises.class);

    // "host:120.26.215.167,password:foobared,poolSize:10"
	private static final String DEFAULT_REDIS_POOL_NAME = "host:120.26.215.167,poolSize:50";//"X_REDIS_CS_COMMON";
	
	private static Map<String, RedisPool> pools = null;
	
	// �������ػ�ȡredis���API��ִ��,ʹ���ܹ��Զ��黹�����ӳ�
	private static Map<String, InvocationHandler> handlers = null;
	
	private String poolName;	// ����InvocationHandler�����ӳ�����
	
	/**
	 * ����ʵ����
	 */
	private Redises(String poolName) {
		super();
		this.poolName = poolName;
	}

	/**
	 * ����pool name��ȡredis pool����
	 * @param poolName ����������
	 * @return
	 */
	public static RedisPool getRedisPool(String poolName) {
		// �������ӳ�Map
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

					// ���첢��ʼ�����ӳ�
					redisPool = new RedisPool(host, port, password, poolSize, timeout);
					redisPool.init();
					
					pools.put(poolName, redisPool);
				}
			}
		}
		
		return redisPool;
	}
	
	/**
	 * ���ַ�����ժȡkeyֵ��Ӧ��Ƭ��
	 * @param str ����key1:value1,key2:value2,....���ַ���
	 * @param key ��Ҫƥ���key
	 * @return key��Ӧ��valueֵ
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
	 * ��ȡredis pool����
	 * @return
	 */
	public static RedisPool getRedisPool() {
		return getRedisPool(DEFAULT_REDIS_POOL_NAME);
	}
	
	/**
	 * ��ָ�����л�ȡredis����,ʹ���߸����ͷ�
	 * @param poolName ������
	 */
	public static Jedis getPooledRedis(String poolName) {
		return getRedisPool(poolName).getRedisFromPool();
	}
	
	/**
	 * ��ȱʡ���л�ȡredis����,ʹ���߸����ͷ�
	 */
	public static Jedis getPooledRedis() {
		return getPooledRedis(DEFAULT_REDIS_POOL_NAME);
	}
	
	/**
	 * ����redis��ȱʡ���ӳ�
	 * @param redis
	 */
	public static void returnToPool(Jedis redis) {
		if (null == redis) {
			return;
		}
		getRedisPool().returnToPool(redis);
	}
	
	/**
	 * ����redis��ָ�����ӳ�
	 * @param poolName
	 * @param redis
	 */
	public static void returnToPool(String poolName, Jedis redis) {
		getRedisPool(poolName).returnToPool(redis);
	}

	/**
	 * ��ָ�����л�ȡjedis commands����,ʹ���������ͷ�
	 * һ�����ڵ�ָ���ִ��,ִ����Ϻ�̬������jedis����黹������
	 * ��һ����Ҫִ�ж��ָ��ʱ,��ʹ��getPooledRedis����ȡjedis�����ֹ��黹
	 * 
	 * @param poolName ������
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
	 * ��ȱʡ���л�ȡjedis commands����,ʹ���������ͷ�
	 * һ�����ڵ�ָ���ִ��,ִ����Ϻ�̬������jedis����黹������
	 * ��һ����Ҫִ�ж��ָ��ʱ,��ʹ��getPooledRedis����ȡjedis�����ֹ��黹
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
		
		// ���������־
		if (log.isDebugEnabled()) {
			log.debug("proxy instance of JedisCommands invoked (methodName:" + method.getName() + ", arguments:" + Arrays.toString(args) + ")");
		}
		
		// �����ӳػ�ȡredis����
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
