package com.zhu.interview.demo;

import org.junit.Test;

/**
 * @Author Zhu
 * @Date 2020/7/14 9:59
 */
public class TestDemo2 {

    @Test
    public void test1() {
        System.out.println(fuc(2012, 2102));

        int i = 0;
        int j = 9;
        do {
            if (i++ > --j) {
                break;
            }
        } while (i < 4);

        System.out.println(i + "   " + j);
    }

    static int fuc(int m, int n) {
        if ((m % n) == 0) {
            return n;
        } else {
            return fuc(n, m % n);
        }
    }

    @Test
    public void test2() {

        int i = 1;
        do {
            i++;
        } while (i > 10);
        System.out.println(i);
    }

    @Test
    public void test3() {

    }


}
