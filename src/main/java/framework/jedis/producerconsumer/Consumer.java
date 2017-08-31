/**
 * Created by shiwx on 2016/4/29.
 * Copyright (c) 2016/4/29 Asiainfo Technologies(China),Inc.
 */
package framework.jedis.producerconsumer;

import framework.jedis.Redises;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author shiwx
 */
public class Consumer {

    private static final Logger log = Logger.getLogger(Consumer.class);

    public static void main(String[] args) {
        String key = "TEST_QUEUE";
        int timeout = 3;

        while(true){
            long start = System.currentTimeMillis();
            Jedis jedis = Redises.getPooledRedis();
            List<String> result = jedis.brpop(timeout, key);
            jedis.close();
            long end = System.currentTimeMillis();
            long cost = (end-start)/1000;
            log.info(cost + " - " + result);
        }

    }
}
