/**
 * Created by shiwx on 2016/4/29.
 * Copyright (c) 2016/4/29 Asiainfo Technologies(China),Inc.
 */
package framework.jedis.producerconsumer;

import framework.jedis.Redises;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

/**
 * @author shiwx
 */
public class Producer {
    private static final Logger log = Logger.getLogger(Producer.class);

    public static void main(String[] args) {
        log.info("start...");

        String key = "TEST_QUEUE";
        String value = "data:" + Math.random();
        Jedis jedis = Redises.getPooledRedis();
        long result = jedis.lpush(key, value);
        jedis.close();
        log.info("result: " + result);
    }
}
