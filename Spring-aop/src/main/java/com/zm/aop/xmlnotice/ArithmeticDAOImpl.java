package com.zm.aop.xmlnotice;

public class ArithmeticDAOImpl implements ArithmeticDAO{
    @Override
    public void plus(int i, int j) {
        System.out.println(i+"+"+j+"="+(i+j));
    }
    @Override
    public int sub(int i, int j) {
        //System.out.println(i+"-"+j+"="+(i-j));
        return i-j;
    }
    @Override
    public void mul(int i, int j) {
        System.out.println(i+"*"+j+"="+(i*j));
    }
   @Override
    public int div(int i, int j) {
      // System.out.println(i+"/"+j+"="+(i/j));
       return i/j;
    }
    @Override
    public void mod(int i, int j) {
        System.out.println(i+"%"+j+"="+(i%j));
    }
}
