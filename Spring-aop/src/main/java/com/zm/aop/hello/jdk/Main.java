package com.zm.aop.hello.jdk;


import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    @Test
    public void test01(){
        //需要被代理的对象
        ArithmeticDAO target = new ArithmeticDAOImpl();
        //获取处理器
        InvocationHandler handler = new ArithmeticLoggingProxy(target);
        //代理对象
        ArithmeticDAO proxy = (ArithmeticDAO)Proxy.newProxyInstance(Main.class.getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.plus(2, 3);
        proxy.sub(3, 1);
    }

    @Test
    public void test02(){
        //需要被代理的对象
        ArithmeticDAOImpl target = new ArithmeticDAOImpl();
        ArithmeticDAO proxy = new ArithmeticLoggingProxy2(target).getLoggingProxy();
        proxy.plus(10,20);
        proxy.sub(10,5);
    }
}
