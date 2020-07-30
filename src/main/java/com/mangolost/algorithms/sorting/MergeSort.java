package com.mangolost.algorithms.sorting;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @param <T>
 */
public class MergeSort<T> implements Sort<T> {

    private Comparable<T>[] aux;

    public MergeSort() {

    }

    public static void main(String[] args) {
        Sort<Integer> sort = new MergeSort<>();

        Integer[] a = {4, 1, 3, 6, 7, 8, 5, 9, 0, 2};

        sort.sort(a);

        System.out.println(Arrays.toString(a));
    }

    /**
     * @param a
     */
    @SuppressWarnings("unchecked")
    @Override
    public void sort(Comparable<T>[] a) {
        aux = new Comparable[a.length];
        int len = a.length;
        mergeSort(a, 0, len - 1);
    }

    /**
     * @param a
     * @param left
     * @param right
     * @return
     */
    private void mergeSort(Comparable<T>[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid); // Sort left half.
        mergeSort(a, mid + 1, right); // Sort right half.
        merge(a, left, mid, right); // Merge results
    }

    /**
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    private void merge(Comparable<T>[] a, int left, int mid, int right) {
        // Merge a[left..mid] with a[mid+1..right].
        if (right + 1 - left >= 0) {
            System.arraycopy(a, left, aux, left, right + 1 - left);
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) { // Merge back to a[lo..hi].
            if (i > mid) {
                a[k] = aux[j];
                j++;
            } else if (j > right) {
                a[k] = aux[i];
                i++;
            } else if (compare(aux[j], aux[i]) < 0) {
                a[k] = aux[j];
                j++;
            } else {
                a[k] = aux[i];
                i++;
            }
        }
    }

}
