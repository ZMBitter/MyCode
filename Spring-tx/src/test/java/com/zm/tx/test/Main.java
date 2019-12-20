package com.zm.tx.test;

import com.zm.tx.bean.Bank;
import com.zm.tx.dao.BankDao;
import com.zm.tx.service.TransferDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {

    private ApplicationContext context;
    private BankDao bankDao;
    private TransferDao transferDao;

    {
        context = new ClassPathXmlApplicationContext("classpath:applicationContext-tx.xml");
        bankDao = (BankDao)context.getBean("bankDao");
        transferDao = (TransferDao) context.getBean("transferDao");
    }
    @Test
    public void test01() throws SQLException {
        //测试数据源是否配置正确
        DataSource dataSource = (DataSource)context.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

    //查询数据库里面bank表中的信息
    @Test
    public void test02(){
        Bank bank = bankDao.findBankById(1);
        System.out.println(bank);
    }

    //验证账户金额是否能转
    @Test
    public void test03(){
        bankDao.updateFrom(1,4000);
    }

    /* 转账业务 */
    @Test
    public void test04(){
        transferDao.transferMoney(2,1,500);
    }
}
