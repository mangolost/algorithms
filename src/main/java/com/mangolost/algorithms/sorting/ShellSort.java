package com.mangolost.algorithms.sorting;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @param <T>
 */
public class ShellSort<T> implements Sort<T> {

    public ShellSort() {

    }

    public static void main(String[] args) {
        Sort<Integer> sort = new ShellSort<>();

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
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (compare(a[j], a[j - h]) < 0) {
                        swap(a, j, j - h);
                    }
                }
            }
            h = h / 3;
        }
    }

}
