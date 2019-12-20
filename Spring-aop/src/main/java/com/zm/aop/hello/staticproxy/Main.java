package com.zm.aop.hello.staticproxy;

public class Main {

    public static void main(String[] args) {
        //目标对象
        Subject realSubject = new RealSubject();
        //代理对象 通过构造器注入目标对象
        Subject proxySubject = new ProxySubject(realSubject);

        proxySubject.request();
        proxySubject.response();


    }
}
