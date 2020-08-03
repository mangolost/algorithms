package com.mangolost.algorithms.mq.strategy;

import com.mangolost.algorithms.mq.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 */
public class BlockingQueueStrategy {

    private static final BlockingQueue<Message> blockingQueue = new LinkedBlockingQueue<>();

    /**
     *
     * @param message
     */
    public static void push(Message message) {
        try {
            blockingQueue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public static Message pull() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
