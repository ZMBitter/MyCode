package com.zm.tx.dao.impl;

import com.zm.tx.autoException.BankException;
import com.zm.tx.bean.Bank;
import com.zm.tx.dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDao")
public class BankDaoImpl implements BankDao {
    @Autowired  //自动装配
    private JdbcTemplate template;

    @Override
    public Bank findBankById(int id) {
        String sql = "select * from bank where id=?";
        Bank bank = template.queryForObject(sql, new BeanPropertyRowMapper<Bank>(Bank.class), id);
        return bank;
    }

    @Override
    public void updateFrom(int fromId, double money) {
        Bank bank = findBankById(fromId);
        double yu = bank.getMoney();
        if(yu<=0){
            throw new BankException("已经没有余额了");
        }else if(yu<money){
            throw new BankException("余额不足，无法执行!");
        }
        String sql = "update bank set money = money - ? where id = ?";
        int update = template.update(sql, money, fromId);
        System.out.println(update);
    }

    @Override
    public void updateTo(int toId, double money) {
        String sql = "update bank set money = money + ? where id = ?";
        int update = template.update(sql, money, toId);
        System.out.println(update);
    }
}
