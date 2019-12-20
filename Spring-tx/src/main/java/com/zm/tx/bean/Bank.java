package com.zm.tx.bean;

import org.springframework.stereotype.Component;

    @Component("bank")
    public class Bank {
        private int id; //序号
        private String cardId; //账号
        private String userName; //用户名
        private double money; //金额

        public Bank() {

        }

        public Bank(int id,String cardId, String userName, double money) {
            this.id = id;
            this.cardId = cardId;
            this.userName = userName;
            this.money = money;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getUserName() {
            return userName;
        }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", cardId='" + cardId + '\'' +
                ", userName='" + userName + '\'' +
                ", money=" + money +
                '}';
    }
}
