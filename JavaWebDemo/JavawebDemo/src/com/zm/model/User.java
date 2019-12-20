package com.zm.model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uId; //ID
    private String username;  //用户名
    private String password;  //密码

    public User() {
    }

    public User(Integer uId, String username, String password) {
        this.uId = uId;
        this.username = username;
        this.password = password;
    }

    public Integer getuId() {
        return uId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
