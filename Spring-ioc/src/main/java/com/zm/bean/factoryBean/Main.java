package com.zm.bean.factoryBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-factoryBean.xml");
        Dept dept = (Dept) context.getBean("dept");
        System.out.println(dept);
    }
}
