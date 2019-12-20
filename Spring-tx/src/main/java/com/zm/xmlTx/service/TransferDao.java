package com.zm.xmlTx.service;

public interface TransferDao {
    public void transferMoney(int fromId, int toId, double money);
}
