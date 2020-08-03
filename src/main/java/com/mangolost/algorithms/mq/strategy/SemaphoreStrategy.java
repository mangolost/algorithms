package com.mangolost.algorithms.mq.strategy;

import com.mangolost.algorithms.mq.Message;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 *
 */
public class SemaphoreStrategy {

    private static final int MAX_SIZE = 10;

    private static final List<Message> list = new LinkedList<>();

    private static final Semaphore notFull = new Semaphore(MAX_SIZE);

    private static final Semaphore notEmpty = new Semaphore(0);

    private static final Semaphore mutex = new Semaphore(1);

    /**
     *
     * @param message
     */
    public static void push(Message message) {
        try {
            notFull.acquire();
            mutex.acquire();
            list.add(message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notEmpty.release();
        }
    }

    /**
     *
     * @return
     */
    public static Message pull() {
        try {
            notEmpty.acquire();
            mutex.acquire();
            Message message = list.remove(0);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            mutex.release();
            notFull.release();
        }
    }

}
