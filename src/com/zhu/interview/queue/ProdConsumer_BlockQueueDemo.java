package com.zhu.interview.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 阻塞队列的线程通信
 *
 * @Author Zhu
 * @Date 2020/6/18 16:47
 */
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) {
        MyResources myResources = new MyResources(new ArrayBlockingQueue<>(5));

        new Thread(() -> {
            System.out.println("生产者线程启动");
            try {
                myResources.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            System.out.println("消费者线程启动");
            try {
                myResources.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();

        try {
            SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t主线程等待6s，结束运行，叫停生产消费");
        myResources.stop();
    }
}

class MyResources {
    private volatile boolean flag = true;
    private BlockingQueue<String> blockingQueue = null;
    private AtomicInteger atomicInteger = new AtomicInteger();

    MyResources(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    void myProd() throws Exception {
        String data;
        while (flag) {
            data = atomicInteger.getAndIncrement() + "";
            boolean result = blockingQueue.offer(data, 2, SECONDS);
            if (result) {
                System.out.println(Thread.currentThread().getName() + "\t" + data + "队列插入成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t队列插入失败");
            }
            try {
                SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t生产停止, flag = false");
    }

    void myConsumer() throws Exception {
        String result = "";
        while (flag) {
            result = blockingQueue.poll(2, SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t队列为空,消费者超过2s没有取到数值");
                return;
            } else {
                System.out.println(Thread.currentThread().getName() + "\t消费者从队列中取出:" + result);
            }
        }
    }

    void stop() {
        this.flag = false;
    }
}
