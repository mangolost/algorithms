package com.mangolost.algorithms.sorting;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @param <T>
 */
public class BubbleSort<T> implements Sort<T> {

    public BubbleSort() {

    }

    public static void main(String[] args) {
        Sort<Integer> sort = new BubbleSort<>();

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
        for (int i = 0; i < len - 1; i++) {
            for (int j = len - 1; j > i; j--) {
                if (compare(a[j], a[j - 1]) < 0) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

}
