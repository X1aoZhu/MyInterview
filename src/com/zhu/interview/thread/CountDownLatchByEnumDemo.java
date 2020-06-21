package com.zhu.interview.thread;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * 枚举的应用
 *
 * @Author Zhu
 * @Date 2020/6/18 14:29
 */
public class CountDownLatchByEnumDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t国被消灭");
                countDownLatch.countDown();
            }, Objects.requireNonNull(CountDownEnum.foreach_CountDownEnum(i)).getMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t秦国一统天下");
    }
}

enum CountDownEnum {
    ONE(1, "楚"),
    TWO(2, "齐"),
    THREE(3, "燕"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩");

    private Integer code;
    private String message;

    CountDownEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CountDownEnum foreach_CountDownEnum(int code) {
        CountDownEnum[] countDownEnums = CountDownEnum.values();
        for (CountDownEnum countDownEnum : countDownEnums) {
            if (code == countDownEnum.getCode()) {
                return countDownEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
