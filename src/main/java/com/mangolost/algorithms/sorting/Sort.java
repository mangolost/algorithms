package com.mangolost.algorithms.sorting;

/**
 *
 * @param <T>
 */
public interface Sort<T> {

    /**
     *
     * @param a
     */
    void sort(Comparable<T>[] a);

    /**
     *
     * @param a
     * @param b
     * @return
     */
    @SuppressWarnings("unchecked")
    default int compare(Comparable<T> a, Comparable<T> b) {
        return a.compareTo((T) b);
    }

    /**
     *
     * @param a
     * @param i
     * @param j
     */
    default void swap(Comparable<T>[] a, int i, int j) {
        Comparable<T> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
