package com.zm.xmlTx.test;

import com.zm.xmlTx.service.TransferDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    @Test
    public void test02() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-xml.xml");
        DataSource dataSource = (DataSource)context.getBean("dataSource");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-xml.xml");
        TransferDao transfer = (TransferDao)context.getBean("transfer");
        transfer.transferMoney(1,2,3500);
    }
}
