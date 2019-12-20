package com.zm.bean.SpEL;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-spel.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car);
    }
}
