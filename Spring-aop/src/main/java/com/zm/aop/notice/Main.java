package com.zm.aop.notice;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void test01(){
        //1.创建Spring的IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-aop.xml");
        //2.从容器中获取Bean对象
        ArithmeticDAO bean = (ArithmeticDAO)context.getBean("arithmeticDAO");
        bean.plus(2,3); //前置通知，后置通知
        //System.out.println("======================================");
        //int sub = bean.sub(10, 2); //返回通知
        //System.out.println("sub result:"+sub);
        System.out.println("======================================");
        int div = bean.div(10, 0);
        System.out.println("div result: "+div);
    }
}
