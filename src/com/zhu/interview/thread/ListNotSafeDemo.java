package com.zhu.interview.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 证明ArrayList线程不安全
 *
 * @Author Zhu
 * @Date 2020/6/8 23:50
 */
public class ListNotSafeDemo {
    public static void main(String[] args) {
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        Map<String, Object> map = new ConcurrentHashMap<String, Object>();

//        List<Object> list = new ArrayList<>();
//        List<Object> list = new Vector<>();
        List<Object> list = new CopyOnWriteArrayList<>();
//        Lock lock = new ReentrantLock(false);

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 10));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
