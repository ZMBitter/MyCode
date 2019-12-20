package com.zm.aop.hello.cglib;

/* CgLib动态代理*/
public class Arithmetic implements ArithmeticDAO{
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
