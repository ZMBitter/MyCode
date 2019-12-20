package com.zm.tx.dao;

import com.zm.tx.bean.Bank;

public interface BankDao {
    //根据序号查询账户信息
    public Bank findBankById(int id);
    //更新bank表中金额信息 转走
    public void updateFrom(int fromId,double money);
    //转入
    public void updateTo(int toId,double money);
}
