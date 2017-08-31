/**
 * Created by shiwx on 2016/4/25.
 * Copyright (c) 2016/4/25 Asiainfo Technologies(China),Inc.
 */
package framework.jedis.pubsub;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author shiwx
 */
public class JedisUtil {

    public static final String REDIS_HOST = "120.26.215.167";
    public static final int REDIS_PORT = 6379;

    final static JedisPoolConfig POOL_CONFIG = new JedisPoolConfig();
    final static JedisPool JEDIS_POOL = new JedisPool(POOL_CONFIG, REDIS_HOST, REDIS_PORT, 0);
}
