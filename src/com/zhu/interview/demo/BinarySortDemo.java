package com.zhu.interview.demo;

/**
 * @Author Zhu
 * @Date 2020/7/16 11:35
 */
public class BinarySortDemo {
    public static void main(String[] args) {
        int[] data = {-49, -30, -16, 9, 0, 21, 23, 30, 30};
        int i = binarySort(data, 0, data.length, 21);
        System.out.println(i);
    }

    private static int binarySort(int[] data, int leftIndex, int rightIndex, int value) {
        if (leftIndex > rightIndex) {
            return -1;
        }
        int middle = (leftIndex + rightIndex) / 2;
        if (data[middle] > value) {
            return binarySort(data, leftIndex, middle, value);
        } else if (data[middle] < value) {
            return binarySort(data, middle, rightIndex, value);
        } else {
            return middle;
        }
    }
}
