package com.zhu.interview.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 减少计数
 *
 * @Author Zhu
 * @Date 2020/6/18 14:16
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t走了");
                countDownLatch.countDown();
            }, String.valueOf(i + 1)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t班长走了");
    }
}
