package com.zhu.interview.queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 *
 * @Author Zhu
 * @Date 2020/6/18 16:20
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put a");
                synchronousQueue.put("a");
                System.out.println(Thread.currentThread().getName() + "\t put b");
                synchronousQueue.put("b");
                System.out.println(Thread.currentThread().getName() + "\t put c");
                synchronousQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            try {
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\t take " + synchronousQueue.take());
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\t take " + synchronousQueue.take());
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\t take " + synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}
