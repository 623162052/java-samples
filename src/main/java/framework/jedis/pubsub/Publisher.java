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
     * ��ͣ�Ķ�ȡ���룬Ȼ�󷢲���channel���棬����quit��ֹͣ������
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
            //ʹ��subscriber����CHANNEL_NAME�ϵ���Ϣ����һ��֮���߳̽��붩��ģʽ��������
            subscriberJedis.subscribe(subscriber, CHANNEL_NAME);

            //��unsubscribe()����������ʱ����ִ�����´���
            log.info("Subscription ended.");
        } catch (Exception e) {
            log.error("Subscribing failed.", e);
        }
    }
}