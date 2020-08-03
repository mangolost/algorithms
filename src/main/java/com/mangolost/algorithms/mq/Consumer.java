package com.mangolost.algorithms.mq;

/**
 *
 */
public class Consumer {

    private String consumerId;

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    /**
     *
     * @return
     */
    public Message consume() {
        Message message = MessageQueue.pull();
        return message;
    }

}
