/**
 * Created by shiwx on 2016/4/29.
 * Copyright (c) 2016/4/29 Asiainfo Technologies(China),Inc.
 */
package framework.jedis.producerconsumer;

import framework.jedis.Redises;
import redis.clients.jedis.Jedis;

/**
 * @author shiwx
 */
public class Test {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            Jedis jedis = Redises.getPooledRedis();
            jedis.get("name");
            jedis.close();
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);

    }
}
