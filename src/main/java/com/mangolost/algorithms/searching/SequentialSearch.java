package com.mangolost.algorithms.searching;

import static com.mangolost.algorithms.common.utils.CommonUtil.compare;

/**
 * 顺序查找
 */
public class SequentialSearch {

    public SequentialSearch() {

    }

    /**
     * 顺序查找
     * @param arr arr是一个数组(排序不排序都一样)
     * @param val val是要搜索的值
     * @return 返回搜索到的index
     */
    public int search(Comparable<?>[] arr, Comparable<?> val) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            Comparable<?> comparable = arr[i];
            if (compare(comparable, val) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SequentialSearch search = new SequentialSearch();
        Integer[] arr = {1982, 1986, 1987, 1989, 1990, 1991, 1992, 1993, 1995};
        Integer val = 1987;
        int index = search.search(arr, val);
        System.out.println(index);
    }

}
