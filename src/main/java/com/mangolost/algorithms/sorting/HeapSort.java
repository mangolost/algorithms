package com.mangolost.algorithms.sorting;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @param <T>
 */
public class HeapSort<T> implements Sort<T> {

    /**
     * @param a
     */
    @Override
    public void sort(Comparable<T>[] a) {
        int len = a.length;
        for (int i = len / 2; i >= 1; i--) {
            sink(a, i, len);
        }
        while (len > 1) {
            swap(a, 0, len - 1);
            len--;
            sink(a, 1, len);
        }
    }

    /**
     * @param a
     * @param i
     * @param len
     */
    private void sink(Comparable<T>[] a, int i, int len) {
        while (i * 2 <= len) {
            int j = i * 2;
            if (j < len && compare(a[j - 1], a[j]) < 0) {
                j++;
            }
            if (compare(a[i - 1], a[j - 1]) >= 0) {
                break;
            }
            swap(a, i - 1, j - 1);
            i = j;
        }
    }

    public static void main(String[] args) {
        Sort<Integer> sort = new HeapSort<>();

        Integer[] a = {4, 1, 3, 6, 7, 8, 5, 9, 0, 2};

        sort.sort(a);

        System.out.println(Arrays.toString(a));
    }

}