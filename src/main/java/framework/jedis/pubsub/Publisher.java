/**
 * Created by shiwx on 2016/4/25.
 * Copyright (c) 2016/4/25 Asiainfo Technologies(China),Inc.
 */
package framework.jedis.pubsub;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Pub
 * @author shiwx
 */
public class Publisher {

    private static final Logger log = Logger.getLogger(Publisher.class);
    public static final String CHANNEL_NAME = "TestChannel";
    private final Jedis publisherJedis;
    private final String channel;

    public Publisher(Jedis publisherJedis, String channel) {
        this.publisherJedis = publisherJedis;
        this.channel = channel;
    }

    /**
     * 不停的读取输入，然后发布到channel上面，遇到quit则停止发布。
     */
    public void startPublish() {
        log.info("Type your message (quit for terminate)");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String line = reader.readLine();
                if (!"quit".equals(line)) {
                    publisherJedis.publish(channel, line);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            log.error("IO failure while reading input", e);
        }
    }


    public static void main(String[] args) {
        final Jedis subscriberJedis = JedisUtil.JEDIS_POOL.getResource();
        final Subscriber subscriber = new Subscriber();

        try {
            log.info("Subscribing to \"MyChannel\". This thread will be blocked.");
            //使用subscriber订阅CHANNEL_NAME上的消息，这一句之后，线程进入订阅模式，阻塞。
            subscriberJedis.subscribe(subscriber, CHANNEL_NAME);

            //当unsubscribe()方法被调用时，才执行以下代码
            log.info("Subscription ended.");
        } catch (Exception e) {
            log.error("Subscribing failed.", e);
        }
    }
}