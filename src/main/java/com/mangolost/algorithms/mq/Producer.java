package com.mangolost.algorithms.mq;

/**
 *
 */
public class Producer {

    private String producerId;

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    /**
     *
     * @param message
     */
    public void produce(Message message) {
        MessageQueue.push(message);
    }

}
