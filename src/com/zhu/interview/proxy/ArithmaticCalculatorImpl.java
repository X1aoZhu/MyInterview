package com.zhu.interview.proxy;

/**
 * @Author Zhu
 * @Date 2020/7/10 15:01
 */
public class ArithmaticCalculatorImpl implements ArithmaticCalculator {

    @Override
    public double add(double i, double j) {
        return i + j;
    }

    @Override
    public double sub(double i, double j) {
        return i - j;
    }

    @Override
    public double mul(double i, double j) {
        return i * j;
    }

    @Override
    public double div(double i, double j) {
        return i / j;
    }
}
