/**
 * Created by shiwx on 2016/4/29.
 * Copyright (c) 2016/4/29 Asiainfo Technologies(China),Inc.
 */
package framework.jedis.hash;

import framework.jedis.Redises;
import redis.clients.jedis.Jedis;

/**
 * ¿ªÆôÊÂÎï
 * @author shiwx
 */
public class HashTest {

    public static void main(String[] args) {
        String key = "HASH_KEY";

        Jedis jedis = null;
        try {
            jedis = Redises.getPooledRedis();
            long result = jedis.hset(key, "1", "2");
            String data = jedis.hget(key, "1");
            System.out.println("data: " + data);
        } finally {
            jedis.close();
        }

    }

}
