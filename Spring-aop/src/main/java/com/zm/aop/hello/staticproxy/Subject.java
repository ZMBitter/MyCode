package com.zm.aop.hello.staticproxy;

/**
 * 代理类与目标类的共同接口
 */
public interface Subject {
    void request();
    void response();
}

