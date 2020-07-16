package com.zhu.interview.demo;

import org.junit.Test;

/**
 * @Author Zhu
 * @Date 2020/7/13 9:50
 */
public class TestDemo extends SimpleTestBase {

    @Test
    public void test1() {
        /*int i = 6;
        i -= i - 1;
        System.out.println(i);*/

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void test2() {
//        for (int i = 0; i < 10; i++) {
//            if (i % 3 == 2) {
//                continue;
//            }
//            if (i % 2 == 0) {
//                System.out.print(i);
//            }
//        }
        System.out.println(Math.round(-7.5));
        System.out.println(Math.round(7.5));
    }


    String str = "B";

    public static void main(String[] args) {
        TestDemo test = new TestDemo();
        System.out.print((test).str);
        System.out.print(((SimpleTestBase) test).str);
    }
}
class SimpleTestBase {
    String str = "A";
}