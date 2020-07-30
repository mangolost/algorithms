package com.mangolost.algorithms.sorting;

import java.util.Arrays;

/**
 *
 * @param <T>
 */
public class SortApp<T> {

    private final Sort<T> sortAlgorithm;

    public SortApp(Sort<T> sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    /**
     * @param a
     */
    @SuppressWarnings("unchecked")
    private void sort(Comparable<T>[] a) {
        Comparable<T>[] x = new Comparable[a.length];
        System.arraycopy(a, 0, x, 0, a.length);
        sortAlgorithm.sort(x);
        print(x);
    }

    /**
     * @param a
     */
    private void print(Comparable<T>[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {

        Integer[] a = {4, 1, 3, 6, 7, 8, 5, 9, 0, 2};

        SortApp<Integer> sortApp1 = new SortApp<>(new SelectionSort<>());
        sortApp1.sort(a);

        SortApp<Integer> sortApp2 = new SortApp<>(new InsertionSort<>());
        sortApp2.sort(a);

        SortApp<Integer> sortApp3 = new SortApp<>(new BubbleSort<>());
        sortApp3.sort(a);

        SortApp<Integer> sortApp4 = new SortApp<>(new QuickSort<>());
        sortApp4.sort(a);

        SortApp<Integer> sortApp5 = new SortApp<>(new ShellSort<>());
        sortApp5.sort(a);

        SortApp<Integer> sortApp6 = new SortApp<>(new MergeSort<>());
        sortApp6.sort(a);

        SortApp<Integer> sortApp7 = new SortApp<>(new HeapSort<>());
        sortApp7.sort(a);

    }


}
