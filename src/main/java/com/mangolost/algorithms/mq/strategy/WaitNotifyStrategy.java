package com.mangolost.algorithms.mq.strategy;

import com.mangolost.algorithms.mq.Message;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 */
public class WaitNotifyStrategy {

    private static final int MAX_SIZE = 10;

    private static final List<Message> list = new LinkedList<>();

    /**
     *
     * @param message
     */
    public static void push(Message message) {
        synchronized (list) {
            while (list.size() >= MAX_SIZE) {
                System.out.println("队列已满");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(message);
            list.notifyAll();
        }
    }

    /**
     *
     * @return
     */
    public static Message pull() {
        synchronized (list) {
            while (list.size() == 0) {
//                System.out.println("队列为空");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.remove(0);
            list.notifyAll();
            return message;
        }
    }

}
