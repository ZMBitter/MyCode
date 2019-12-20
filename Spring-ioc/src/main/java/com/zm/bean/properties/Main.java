package com.zm.bean.properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    @Test
    public void test01() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-properties.xml");
      /* DataSource c3p0DataSource = (DataSource)context.getBean("c3p0DataSource");
        Connection conn01 = c3p0DataSource.getConnection();
        System.out.println(conn01);
        conn01.close();*/

      /*  DataSource druidDataSource = (DataSource) context.getBean("druidDataSource");
        Connection conn02 = druidDataSource.getConnection();
        System.out.println(conn02);
        conn02.close();*/

       /* DataSource dbcpDataSource = (DataSource) context.getBean("dbcpDataSource");
        Connection conn03 = dbcpDataSource.getConnection();
        System.out.println(conn03);
        conn03.close();*/

      /*  DataSource springDataSource = (DataSource) context.getBean("springDataSource");
        Connection conn04 = springDataSource.getConnection();
        System.out.println(conn04);
        conn04.close();*/

    }
}
