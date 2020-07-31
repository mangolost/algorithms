package com.mangolost.algorithms.sorting;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @param <T>
 */
public class SelectionSort<T> implements Sort<T> {

    /**
     * @param a
     */
    @Override
    public void sort(Comparable<T>[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            Comparable<T> minValue = a[minIndex];
            for (int j = i + 1; j < len; j++) {
                Comparable<T> nowValue = a[j];
                if (compare(nowValue, minValue) < 0) {
                    minIndex = j;
                    minValue = nowValue;
                }
            }
            if (minIndex != i) {
                swap(a, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        Sort<Integer> sort = new SelectionSort<>();

        Integer[] a = {4, 1, 3, 6, 7, 8, 5, 9, 0, 2};

        sort.sort(a);

        System.out.println(Arrays.toString(a));
    }

}
