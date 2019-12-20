package com.zm.aop.xmlnotice;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void test01(){
        //1.创建Spring的IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-xml.xml");
        //2.从容器中获取Bean对象
        ArithmeticDAO bean = (ArithmeticDAO)context.getBean("arithmeticDAOxml");
        bean.plus(2,5);
        System.out.println("===================================================");
        int div = bean.div(10, 0);
        System.out.println("div:"+div);
    }
}
