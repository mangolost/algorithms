package com.mangolost.algorithms.mq;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class MqApp {

    private static final int PRODUCER_NUM = 8;
    private static final int CONSUMER_NUM = 2;
    private static final AtomicInteger id = new AtomicInteger(0);
    private static final Random RD = new Random();

    /**
     *
     */
    private void doPlay() {
        for (int i = 1; i <= PRODUCER_NUM; i++) {
            int finalI = i;
            new Thread(() -> {
                Producer producer = new Producer();
                producer.setProducerId("生产者" + finalI);
                while (true) {
                    Message message = new Message();
                    message.setMessageId("消息" + id.addAndGet(1));
//                    message.setTimestamp(System.currentTimeMillis());
//                    message.setData(null);
                    producer.produce(message);
                    System.out.println(producer.getProducerId() + "生产了" + message.getMessageId());
                    try {
                        long ts = 1000 * (1 + RD.nextInt(5));
                        Thread.sleep(ts);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 1; i <= CONSUMER_NUM; i++) {
            int finalI = i;
            new Thread(() -> {
                Consumer consumer = new Consumer();
                consumer.setConsumerId("消费者" + finalI);
                while (true) {
                    Message message = consumer.consume();
                    System.out.println(consumer.getConsumerId() + "消费了" + message.getMessageId());
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        MqApp mqApp = new MqApp();
        mqApp.doPlay();
    }

}
