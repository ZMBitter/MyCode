package com.zm.aop.hello.jdk;

public interface ArithmeticDAO {
    //+ 加
    public void plus(int i, int j);
    //- 减
    public void sub(int i, int j);
   //* 乘
    public void mul(int i, int j);
   //div 除
    public void div(int i, int j);
   //求余（取模）
    public void mod(int i, int j);
}
