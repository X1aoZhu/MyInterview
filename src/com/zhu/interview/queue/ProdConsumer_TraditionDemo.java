package com.zhu.interview.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 传统的生产者消费者模式
 * 实现多个线程加1，减 1，最终保证数值仍为0
 *
 * @Author Zhu
 * @Date 2020/6/18 16:34
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        MyMethod myMethod = new MyMethod();

        for (int i = 0; i < 50; i++) {
            new Thread(myMethod::increment, "AA").start();
            new Thread(myMethod::decrement, "BB").start();
        }
    }
}

class MyMethod {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 数字加一
     */
    void increment() {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t完成加一操作，当前数为：" + (++num));
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 数字减一
     */
    void decrement() {
        lock.lock();
        try {
            while (num != 1) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t完成减一操作，当前数为：" + (--num));
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}