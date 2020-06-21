package com.zhu.interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程的定制化通信：
 * 实现：A->B->C 按照顺序打印
 *
 * @Author Zhu
 * @Date 2020/6/18 17:24
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        int count = 10;
        MyThread myThread = new MyThread();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                myThread.print5();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                myThread.print10();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                myThread.print15();
            }
        }, "CC").start();

    }
}

class MyThread {
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    void print5() {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t线程1执行" + (i + 1));
            }
            num++;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void print10() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t线程2执行" + (i + 1));
            }
            num++;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void print15() {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t线程3执行" + (i + 1));
            }
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
