package com.mangolost.algorithms.sorting;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @param <T>
 */
public class InsertionSort<T> implements Sort<T> {

    public InsertionSort() {

    }

    public static void main(String[] args) {
        Sort<Integer> sort = new InsertionSort<>();

        Integer[] a = {4, 1, 3, 6, 7, 8, 5, 9, 0, 2};

        sort.sort(a);

        System.out.println(Arrays.toString(a));
    }

    /**
     * @param a
     */
    @Override
    public void sort(Comparable<T>[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && (compare(a[j], a[j - 1]) < 0); j--) {
                swap(a, j, j - 1);
            }
        }
    }

}
