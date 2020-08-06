package com.mangolost.algorithms.lru.lru1;

/**
 *
 */
public class LRUApp1 {

    private final LRUCache<Integer, Integer> lruCache = new LRUCache<>(10);

    private void init() {
        for (int i = 0; i < 10; i++) {
            lruCache.put(i, i);
        }
    }

    /**
     *
     */
    private void doRun() {
        init();
        System.out.println();
        lruCache.get(3);
        System.out.println();
        lruCache.put(4, 44);
        System.out.println();
        lruCache.put(15, 15);
        System.out.println();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        LRUApp1 app = new LRUApp1();
        app.doRun();
    }

}
