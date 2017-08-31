/**
 * Created on 2010-11-9 上午11:39:00
 * Copyright (c) 2010-11-9 Asiainfo Technologies(China),Inc.
 */
package framework.jedis;

import java.util.concurrent.TimeoutException;

import org.apache.commons.pool.impl.GenericObjectPool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis池
 * 
 * @author guyu
 */
public class RedisPool {

	public static final int DEFAULT_PORT_NUM = 6379;
	public static final int DEFAULT_TIMEOUT = 3000;
	public static final int DEFAULT_POOL_SIZE = 15;
	
	private String host;
    private int port;
    private int timeout;
    private String password;
    private int poolSize;
    
    private JedisPool jedisPool = null;
    
    /**
     * constructor
     */
	public RedisPool() {
		super();
		this.port = DEFAULT_PORT_NUM;
		this.timeout = DEFAULT_TIMEOUT;
		this.poolSize = DEFAULT_POOL_SIZE;
	}
	
    /**
     * constructor
     * @param host redis主机
     * @param port redis端口
     * @param password 认证密码
     * @param poolSize 池大小
     * @param timeout 连接超时,毫秒
     */
	public RedisPool(String host, int port, String password, int poolSize, int timeout) {
		super();
		
		this.host = host;
		this.port = port;
		this.password = password;
		this.timeout = timeout;
		this.poolSize = poolSize;
	}
	
	/**
	 * constructor
	 * @param host
	 * @param port
	 * @param password
	 * @param poolSize
	 */
	public RedisPool(String host, int port, String password, int poolSize) {
		this(host, port, password, poolSize, DEFAULT_TIMEOUT);
	}
	
	/**
	 * constructor
	 * @param host
	 * @param port
	 * @param password
	 */
	public RedisPool(String host, int port, String password) {
		this(host, port, password, DEFAULT_POOL_SIZE);
	}
	
	/**
	 * constructor
	 * @param host
	 * @param password
	 */
	public RedisPool(String host, String password) {
		this(host, DEFAULT_PORT_NUM, password);
	}
	
	/**
	 * 获取池中的redis客户端对象
	 * @return
	 * @throws TimeoutException 
	 */
	public Jedis getRedisFromPool() {
		Jedis jedis = null;
		if (null != jedisPool) {
			jedis = jedisPool.getResource();
		}
		return jedis;
	}
	
	/**
	 * 获取池中的redis客户端对象
	 * @param database 选择的数据库id
	 * @return
	 */
	public Jedis getRedisFromPool(int database) {
		Jedis jedis = getRedisFromPool();
		if ((null != jedis) && (database > 0)) {
			jedis.select(database);
		}
		return jedis;
	}
	
	/**
	 * 将redis返回给连接池
	 * @param redis
	 */
	public void returnToPool(Jedis redis) {
		if (null != redis) {
			jedisPool.returnResource(redis);
		}
	}

	/**
	 * 初始化Redis池
	 */
	public void init() {
		if (null != jedisPool)
			return;
		
		JedisPoolConfig config = new JedisPoolConfig();
//		config.setMaxActive(this.poolSize);
		config.setMinIdle(5);
//		int maxIdle = config.minIdle + 5;
//		if (maxIdle > config.maxActive) {
//			maxIdle = config.maxActive;
//		}
//		config.setMaxIdle(maxIdle);
//		config.setMaxWait(1000L);
//		config.setWhenExhaustedAction(GenericObjectPool.WHEN_EXHAUSTED_BLOCK);
		config.setTestOnBorrow(false);
		config.setTestOnReturn(false);
		config.setTestWhileIdle(true);
		config.setMinEvictableIdleTimeMillis(600000);	// 空闲对象,空闲多长时间会被驱逐出池里
		config.setTimeBetweenEvictionRunsMillis(30000); // 驱逐线程30秒执行一次
		config.setNumTestsPerEvictionRun(-1);			//-1,表示在驱逐线程执行时,测试所有的空闲对象
		
		jedisPool = new JedisPool(config, this.host, this.port, this.timeout, this.password);
	}
	
	/**
	 * 销毁Redis池
	 */
	public void destroy() {
		if (null != jedisPool) {
			JedisPool _pool = jedisPool;
			jedisPool = null;
			
			_pool.destroy();
		}
	}
	
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}
	
	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the poolSize
	 */
	public int getPoolSize() {
		return poolSize;
	}
	
	/**
	 * @param poolSize the poolSize to set
	 */
	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}
	
}
