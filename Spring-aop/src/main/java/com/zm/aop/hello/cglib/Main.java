package com.zm.aop.hello.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class Main {
    @Test
    public void test01(){
      /* 获取Enhance对象
        Enhancer enhancer = new Enhancer();
        设置目标类
        enhancer.setSuperclass(ArithmeticDAOImpl.class);
       调用回调方法
        enhancer.setCallback(new ArithmeticInteceptor());
         ArithmeticDAOImpl proxy = (ArithmeticDAOImpl)enhancer.create();
        相当于以下一句
       */
        //获取代理对象
        Arithmetic proxy = (Arithmetic)Enhancer.create(Arithmetic.class, new ArithmeticInteceptor());
        proxy.plus(10,20);
        proxy.sub(10,5);
    }
}
