package com.zhu.interview.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 可重用锁例子
 *
 * @Author Zhu
 * @Date 2020/6/9 1:01
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Person1 person1 = new Person1();

        Thread thread1 = new Thread(person1, "t1");
        Thread thread2 = new Thread(person1, "t2");

        thread1.start();
        thread2.start();

    }
}

class Person1 implements Runnable {
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t执行get()");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t执行set()");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
