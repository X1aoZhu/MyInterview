package com.zhu.interview.demo;

/**
 * @Author Zhu
 * @Date 2020/7/16 11:35
 */
public class BinarySortDemo {
    public static void main(String[] args) {
        int[] data = {-49, -30, -16, 9, 21, 21, 23, 30, 30};
        int i = binarySort(data, 0, data.length, 21);
        System.out.println(i);
    }

    private static int binarySort(int[] data, int leftIndex, int rightIndex, int value) {

        if (leftIndex > rightIndex) return -1;

        int middle = (leftIndex + rightIndex) / 2;

        if (value < data[middle]) {
            rightIndex = middle;
            return binarySort(data, leftIndex, rightIndex, value);
        } else if (value > data[middle]) {
            leftIndex = middle;
            return binarySort(data, leftIndex, rightIndex, value);
        } else {
            return middle;
        }
    }
}
