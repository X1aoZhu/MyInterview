package com.zhu.interview.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Zhu
 * @Date 2020/7/10 15:00
 */
public class AutoProxyUtil {

    private Object target;

    public AutoProxyUtil(Object target) {
        this.target = target;
    }

    Object proxy() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {

                System.out.println("Before AutoProxy");

                Object result = method.invoke(target, args);

                System.out.println("After AutoProxy");

                return result;
            }
        });
    }

}
