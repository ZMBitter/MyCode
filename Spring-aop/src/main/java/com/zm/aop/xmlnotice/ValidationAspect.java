package com.zm.aop.xmlnotice;

import org.aspectj.lang.JoinPoint;;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

public class ValidationAspect {

    public void beforeMethod(JoinPoint point){
        String name = point.getSignature().getName();
        Object[] args = point.getArgs();
        System.out.println("==>前置切面：The method "+name+" begin with args "+ Arrays.asList(args));
    }
}
