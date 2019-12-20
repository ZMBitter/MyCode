package com.zm.xmlTx.service.impl;

import com.zm.xmlTx.dao.BankDao;
import com.zm.xmlTx.service.TransferDao;

public class TransferImpl implements TransferDao {

    private BankDao bankDao;

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Override  //银行转账
    public void transferMoney(int fromId,int toId,double money) {
        /*A账户转向B账户*/

        //从A账户中扣除相应的金额
        bankDao.updateFrom(fromId,money);
        //B账户中增加相应的金额
        bankDao.updateTo(toId,money);
    }
}
