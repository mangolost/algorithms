package com.mangolost.algorithms.sorting;

import java.util.Arrays;

/**
 * 快速排序
 *
 */
public class QuickSort implements Sort {

    /**
     * @param a
     */
    @Override
    public void sort(Comparable<?>[] a) {
        int len = a.length;
        quickSort(a, 0, len - 1);
    }

    /**
     * @param a
     * @param left
     * @param right
     */
    private void quickSort(Comparable<?>[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = partition(a, left, right); //把数组重新排序，使得mid左边的比a[mid]小, mid右边的比a[mid]大, 并返回mid
        quickSort(a, left, mid - 1); // 递归调用排序左边
        quickSort(a, mid + 1, right); // 递归调用排序右边
    }

    /**
     * @param a
     * @param left
     * @param right
     * @return
     */
    private int partition(Comparable<?>[] a, int left, int right) {
        Comparable<?> v = a[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (compare(a[i], v) < 0) {
                if (i == right) {
                    break;
                }
                i++;
            }
            while (compare(v, a[j]) < 0) {
                if (j == left) {
                    break;
                }
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, left, j);
        return j;
    }

    public static void main(String[] args) {
        Sort sort = new HeapSort();

        Integer[] a = {4, 1, 3, 6, 7, 8, 5, 9, 0, 2};

        sort.sort(a);

        System.out.println(Arrays.toString(a));
    }

}
