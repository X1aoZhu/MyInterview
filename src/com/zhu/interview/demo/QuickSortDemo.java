package com.zhu.interview.demo;

/**
 * @Author Zhu
 * @Date 2020/7/16 11:14
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] data = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort(data, 0, data.length - 1);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }

    private static void quickSort(int[] data, int low, int high) {
        int i, j, temp, k;
        if (low > high) return;

        i = low;
        j = high;
        temp = data[low];

        while (i < j) {
            while (temp <= data[j] && i < j) {
                j--;
            }
            while (temp >= data[i] && i < j) {
                i++;
            }

            if (i < j) {
                k = data[j];
                data[j] = data[i];
                data[i] = k;
            }

            data[low] = data[i];
            data[i] = temp;

            quickSort(data, low, j - 1);
            quickSort(data, j + 1, high);
        }
    }
}


