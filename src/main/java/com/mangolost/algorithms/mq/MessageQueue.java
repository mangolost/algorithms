package com.mangolost.algorithms.mq;

import com.mangolost.algorithms.mq.strategy.AwaitSignalStrategy;
import com.mangolost.algorithms.mq.strategy.BlockingQueueStrategy;
import com.mangolost.algorithms.mq.strategy.SemaphoreStrategy;
import com.mangolost.algorithms.mq.strategy.WaitNotifyStrategy;

/**
 *
 */
public class MessageQueue {

    /**
     *
     * @param message
     */
    public static void push(Message message) {
//        BlockingQueueStrategy.push(message);
//        WaitNotifyStrategy.push(message);
//        AwaitSignalStrategy.push(message);
        SemaphoreStrategy.push(message);
    }

    /**
     *
     * @return
     */
    public static Message pull() {
//        return BlockingQueueStrategy.pull();
//        return WaitNotifyStrategy.pull();
//        return AwaitSignalStrategy.pull();
        return SemaphoreStrategy.pull();
    }

}
