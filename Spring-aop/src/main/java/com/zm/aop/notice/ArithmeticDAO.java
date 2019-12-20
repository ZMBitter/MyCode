package com.zm.aop.notice;

public interface ArithmeticDAO {
    //+ 加
    public void plus(int i, int j);
    //- 减
    public int sub(int i, int j);
   //* 乘
    public void mul(int i, int j);
   //div 除
    public int div(int i, int j);
   //求余（取模）
    public void mod(int i, int j);
}
