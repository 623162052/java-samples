/**
 * Created by shiwx on 2016/4/26.
 * Copyright (c) 2016/4/26 Asiainfo Technologies(China),Inc.
 */
package framework.jedis.sortedset;

import framework.jedis.Redises;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiwx
 */
public class SortedSetTest {
    private static final Logger log = Logger.getLogger(SortedSetTest.class);

    /**
     * zadd
     */
    public static void zAdd(){
        String key = "REQUEST_TRANS_MAN";

        Redises.getPooledRedis().zadd(key, 1.1d, "101");
        Redises.getPooledRedis().zadd(key, 1.9d, "102");
        Redises.getPooledRedis().zadd(key, 1.8d, "103");
        Redises.getPooledRedis().zadd(key, 1.2d, "104");
        Redises.getPooledRedis().zadd(key, 1.3d, "105");
        Redises.getPooledRedis().zadd(key, 1.5d, "106");
        Redises.getPooledRedis().zadd(key, 1.6d, "107");
    }

    /**
     * zcard
     */
    public static void zCard(){
        String key = "REQUEST_TRANS_MAN";
        long count = Redises.getPooledRedis().zcard(key);
        log.info("count: " + count);
    }

    /**
     * zcount
     */
    public static void zCount(){
        String key = "REQUEST_TRANS_MAN";
        long count = Redises.getPooledRedis().zcount(key, 1.0d, 1.02d);
        log.info("count: " + count);
    }

    /**
     * zrem
     */
    public static void zRem(){
        String key = "REQUEST_TRANS_MAN";
        long result = Redises.getPooledRedis().zrem(key, "101");
        log.info("result: " + result);
    }

    public static void main(String[] args) {
        zAdd();
    }
}
