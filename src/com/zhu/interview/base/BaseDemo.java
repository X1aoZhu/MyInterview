package com.zhu.interview.base;

import org.junit.Test;

/**
 * @Author Zhu
 * @Date 2020/7/6 9:28
 */
public class BaseDemo {

    /**
     * 验证数组是引用类型
     */
    @Test
    public void test1() {
        int[] a = {1, 2, 3};
        int[] b = a;
        b[2] = 100;
        System.out.println(a.length);
        System.out.println(a[2]);
        System.out.println(b[2]);
    }


    /**
     * 数组翻转
     */
    @Test
    public void testArray() {
        int[] a = {1, 2, 3, 4};
        int[] b = new int[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            b[i] = a[a.length - i - 1];
        }

        for (int i : b) {
            System.out.println(i);
        }
    }

    @Test
    public void testBubbleSort() {
        int[] a = {20, 30, 1, 50, 99, 100};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[a.length - 1 - i]) {
                    int temp = a[j];
                    a[j] = a[a.length - 1 - i];
                    a[a.length - 1 - i] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
