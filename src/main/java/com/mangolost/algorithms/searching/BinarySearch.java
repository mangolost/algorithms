package com.mangolost.algorithms.searching;

/**
 * 二分查找
 */
public class BinarySearch {

    public BinarySearch() {

    }

    /**
     * 二分查找
     * @param arr arr是一个已经排序好的数组
     * @param val val是要搜索的值
     * @return 返回搜索到的index
     */
    public int search(Comparable<?>[] arr, Comparable<?> val) {


        //todo
        return 3;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        Integer[] arr = {1982, 1986, 1987, 1989, 1990, 1991, 1992, 1993, 1995};
        Integer val = 1987;
        int index = search.search(arr, val);
        System.out.println(index);
    }


}
