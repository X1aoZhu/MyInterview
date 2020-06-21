package com.zhu.interview.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS Demo
 *
 * @Author Zhu
 * @Date 2020/6/5 1:20
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t" + atomicInteger.get());

        atomicInteger.getAndIncrement();


    }
}
