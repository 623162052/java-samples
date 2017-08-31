/**
 * Created by shiwx on 2016/4/25.
 * Copyright (c) 2016/4/25 Asiainfo Technologies(China),Inc.
 */
package framework.jedis.pubsub;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Sub
 * @author shiwx
 */
public class Subscriber extends JedisPubSub {//注意这里继承了抽象类JedisPubSub

    private static final Logger log = Logger.getLogger(Subscriber.class);

    @Override
    public void onMessage(String channel, String message) {
        log.info(String.format("Message. Channel: %s, Msg: %s", channel, message));
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        log.info(String.format("PMessage. Pattern: %s, Channel: %s, Msg: %s",
                pattern, channel, message));
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        log.info("onSubscribe");
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        log.info("onUnsubscribe");
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        log.info("onPUnsubscribe");
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        log.info("onPSubscribe");
    }

    public static final String CHANNEL_NAME = "TestChannel";
    public static void main(String[] args) {

        final Jedis publisherJedis = JedisUtil.JEDIS_POOL.getResource();

        //主线程：发布消息到CHANNEL_NAME频道上
        new Publisher(publisherJedis, CHANNEL_NAME).startPublish();
        publisherJedis.close();
    }
}