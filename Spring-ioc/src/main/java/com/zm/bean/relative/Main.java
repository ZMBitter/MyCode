package com.zm.bean.relative;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-relative.xml");
        /*Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);*/
        //使用继承Bean。dept02这个对象继承了dept这个对象的信息（配置信息）
       /* Dept dept02 = context.getBean("dept02", Dept.class);
        System.out.println(dept02);*/

       //使用继承Bean。子Bean可以覆盖从父Bean继承过来的配置
      /*  Dept dept03 = context.getBean("dept03", Dept.class);
        System.out.println(dept03);*/

        //抽象bean：bean的abstract属性的值为true。B这样的Bean不能被IOC容器实
        // 例化，只能被用来继承配置。在子Bean中写实现的属性
       /* Dept dept05 = context.getBean("dept05", Dept.class);
        System.out.println(dept05);*/

       //依赖关系。Employee依赖于Dept
        Employee emp = context.getBean("emp", Employee.class);
        System.out.println(emp);
        Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }
}
