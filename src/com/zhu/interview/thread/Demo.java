package com.zhu.interview.thread;

/**
 * @Author Zhu
 * @Date 2020/6/3 1:11
 */
public class Demo {
    volatile int n = 0;

    public void add() {
        n++;
    }
}
