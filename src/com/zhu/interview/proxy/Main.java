package com.zhu.interview.proxy;

/**
 * @Author Zhu
 * @Date 2020/7/10 15:06
 */
public class Main {
    public static void main(String[] args) {

        AutoProxyUtil autoProxyUtil = new AutoProxyUtil(new ArithmaticCalculatorImpl());
        ArithmaticCalculator proxy = (ArithmaticCalculator)autoProxyUtil.proxy();
        double add = proxy.add(1, 1);
        System.out.println(add);
    }
}
