package com.zhu.interview.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * threadPoolDemo
 *
 * @Author Zhu
 * @Date 2020/6/21 22:37
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        try {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                singleThreadExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + finalI);
                });
//                try {
//                    TimeUnit.MILLISECONDS.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            singleThreadExecutor.shutdown();
        }
    }
}
