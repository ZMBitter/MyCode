package com.zm.bean.autowired;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-autowired.xml");
        Employee emp = context.getBean("emp", Employee.class);
        System.out.println(emp);
        Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }
}
