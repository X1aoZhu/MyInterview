package com.zhu.interview.thread;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @Author Zhu
 * @Date 2020/6/3 2:06
 */
public class SingletonDemo {

    private volatile static SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\tsingletonDemo constructor is run");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
