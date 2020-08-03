package com.mangolost.algorithms.mq.strategy;

import com.mangolost.algorithms.mq.Message;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class AwaitSignalStrategy {

    private static final int MAX_SIZE = 10;

    private static final List<Message> list = new LinkedList<>();

    private static final Lock lock = new ReentrantLock();

    private static final Condition fullCondition = lock.newCondition();

    private static final Condition emptyCondition = lock.newCondition();

    /**
     *
     * @param message
     */
    public static void push(Message message) {
        lock.lock();
        try {
            while (list.size() >= MAX_SIZE) {
                System.out.println("队列已满");
                try {
                    fullCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(message);
            emptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     *
     * @return
     */
    public static Message pull() {
        lock.lock();
        try {
            while (list.size() == 0) {
//            System.out.println("队列为空");
                try {
                    emptyCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.remove(0);
            fullCondition.signalAll();
            return message;
        } finally {
            lock.unlock();
        }
    }

}
