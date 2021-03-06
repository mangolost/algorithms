package com.mangolost.algorithms.searching;

import static com.mangolost.algorithms.common.utils.CommonUtil.compare;

/**
 * 二分查找
 */
public class BinarySearch {

    public BinarySearch() {

    }

    /**
     * 二分查找
     * @param arr arr是一个已经从小到大排序好的数组
     * @param val val是要搜索的值
     * @return 返回搜索到的index
     */
    public int search(Comparable<?>[] arr, Comparable<?> val) {

        int len = arr.length;
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (compare(arr[mid], val) == 0) {
                return mid;
            } else if (compare(arr[mid], val) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        Integer[] arr = {1982, 1986, 1987, 1989, 1990, 1991, 1992, 1993, 1995};
        Integer val = 1987;
        int index = search.search(arr, val);
        System.out.println(index);
    }


}
