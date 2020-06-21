package com.zhu.interview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author Zhu
 * @Date 2020/6/21 21:39
 */
public class MyCallableDemo {
    public static void main(String[] args) throws Exception {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(futureTask, "AA");
        thread.start();

        System.out.println("main result:" + futureTask.get());
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t My Callable invoke");
        return 1024;
    }
}
