package com.zhu.interview.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏
 *
 * @Author Zhu
 * @Date 2020/6/18 14:48
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("集齐七颗龙珠，召唤神龙"));
        for (int i = 0; i < 7; i++) {
            int finalI = i + 1;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t找到第" + finalI + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
