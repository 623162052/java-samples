/**
 * Created by shiwx on 2016/4/14.
 * Copyright (c) 2016/4/14 Asiainfo Technologies(China),Inc.
 */
package framework.jedis;

/**
 * @author shiwx
 */
public class RedisTest {

    public static void main(String[] args) {
        String aaa = Redises.getPooledRedis().set("1","2");
        System.out.println("aaa: " + aaa);
    }
}