package com.zhu.interview.demo;

/**
 * 线程安全的懒汉式
 *
 * @Author Zhu
 * @Date 2020/7/16 12:01
 */
public class SingletonLock {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton.getInstance().hashCode());
            }, String.valueOf(i)).start();
        }
    }
}

class Singleton {

    private volatile static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}