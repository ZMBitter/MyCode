package com.zm.tx.service.impl;

import com.zm.tx.dao.BankDao;
import com.zm.tx.service.TransferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transferDao")
public class TransferImpl implements TransferDao {
    @Autowired
    private BankDao bankDao;

    @Transactional  //添加事务注解，表示使用事务管理机制
    @Override  //银行转账
    public void transferMoney(int fromId,int toId,double money) {
        /*A账户转向B账户*/

        //从A账户中扣除相应的金额
        bankDao.updateFrom(fromId,money);
        //B账户中增加相应的金额
        bankDao.updateTo(toId,money);
    }
}
