package com.zhu.interview.thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile 关键字
 *
 * @Author Zhu
 * @Date 2020/6/2 1:51
 */
public class VolatileDemo {
    public static void main(String[] args) {
        isAtomicity();
    }

    private static void isAtomicity() {
        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                // 理论上执行结果为 20*1000
                for (int j = 0; j < 1000; j++) {
                    myData.setNumAdd();
                    myData.myAtomicInteger();
                }
            }, String.valueOf(i)).start();
        }

        //需要上方20线程全部完成计算之后，才执行主线程进行输出结果
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " finally num value is " + myData.num);
        System.out.println(Thread.currentThread().getName() + " finally num value is " + myData.atomicInteger);
    }

    /**
     * volatile 可见性示例
     */
    private static void visibility() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.setNumTo60();
            System.out.println(Thread.currentThread().getName() + " change num success," + myData.num);
        }, "AA").start();

        while (myData.num == 1) {
            // 死循环
        }
        System.out.println(Thread.currentThread().getName() + "do Main Thread , mission is over");
    }
}

class MyData {

    volatile int num = 0;

    void setNumTo60() {
        this.num = 60;
    }

    void setNumAdd() {
        this.num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    void myAtomicInteger() {
        atomicInteger.getAndIncrement();
    }
}


