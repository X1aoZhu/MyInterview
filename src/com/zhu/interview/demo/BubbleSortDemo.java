package com.zhu.interview.demo;

import java.util.Arrays;

/**
 * @Author Zhu
 * @Date 2020/7/16 22:24
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {1, 20, 2, 232, -10, 0, 100, 52, 29, 29};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    private static int[] bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }
}
