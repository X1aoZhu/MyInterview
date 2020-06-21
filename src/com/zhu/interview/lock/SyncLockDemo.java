package com.zhu.interview.lock;

/**
 * synchroized递归锁Demo
 *
 * @Author Zhu
 * @Date 2020/6/9 0:55
 */
public class SyncLockDemo {
    public static void main(String[] args) {
        Person person = new Person();

        new Thread(() -> {
            person.sendSMS();
        }, "AA").start();

        new Thread(() -> {
            person.sendSMS();
        }, "BB").start();

    }
}

class Person {
    synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "\t发送短信");
        sendEmail();
    }

    synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\t发送邮件");
    }
}