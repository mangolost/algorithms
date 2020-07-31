package com.mangolost.algorithms.sorting;

/**
 *
 */
public interface Sort {

    /**
     * @param a
     */
    void sort(Comparable<?>[] a);

    /**
     * @param a
     * @param b
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    default int compare(Comparable a, Comparable b) {
        return a.compareTo(b);
    }

    /**
     * @param a
     * @param i
     * @param j
     */
    default void swap(Comparable<?>[] a, int i, int j) {
        Comparable<?> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
