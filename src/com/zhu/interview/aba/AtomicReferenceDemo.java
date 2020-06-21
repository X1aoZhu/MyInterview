package com.zhu.interview.aba;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用
 *
 * @Author Zhu
 * @Date 2020/6/8 22:44
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User u1 = new User("admin", 20);
        User u2 = new User("root", 18);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(u1);

        System.out.println(atomicReference.compareAndSet(u1, u2) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(u1, u2) + "\t" + atomicReference.get().toString());
    }
}
