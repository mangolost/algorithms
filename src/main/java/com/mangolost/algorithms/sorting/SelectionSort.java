package com.mangolost.algorithms.sorting;

import java.util.Arrays;

/**
 * 选择排序
 *
 */
public class SelectionSort implements Sort {

    /**
     * @param a
     */
    @Override
    public void sort(Comparable<?>[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            Comparable<?> minValue = a[minIndex];
            for (int j = i + 1; j < len; j++) {
                Comparable<?> nowValue = a[j];
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
        Sort sort = new HeapSort();

        Integer[] a = {4, 1, 3, 6, 7, 8, 5, 9, 0, 2};

        sort.sort(a);

        System.out.println(Arrays.toString(a));
    }

}
