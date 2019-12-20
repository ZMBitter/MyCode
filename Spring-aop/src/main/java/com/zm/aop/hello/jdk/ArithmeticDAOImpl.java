package com.zm.aop.hello.jdk;

public class ArithmeticDAOImpl implements ArithmeticDAO {
    @Override
    public void plus(int i, int j) {
        System.out.println(i+"+"+j+"="+(i+j));
    }
    @Override
    public void sub(int i, int j) {
        System.out.println(i+"-"+j+"="+(i-j));
    }
    @Override
    public void mul(int i, int j) {
        System.out.println(i+"*"+j+"="+(i*j));
    }
    @Override
    public void div(int i, int j) {
        System.out.println(i+"/"+j+"="+(i/j));
    }
    @Override
    public void mod(int i, int j) {
        System.out.println(i+"%"+j+"="+(i%j));
    }
}
