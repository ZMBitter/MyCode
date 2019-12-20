package com.zm.aop.notice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Order(1) //使用@Order注解设置优先级
@Component
@Aspect
public class ValidationAspect {

    /* 定义一个方法，用于声明切入点表达式.一般的，该方法中不需要再添加其
    他代码 */
    @Pointcut("execution(* com.zm.aop.notice.ArithmeticDAO.*(..))")
   public void declareJoinPointExcepression(){}

    @Before(value = "declareJoinPointExcepression()")
    public void beforeMethod(JoinPoint point){
        String name = point.getSignature().getName();
        Object[] args = point.getArgs();
        System.out.println("==>前置切面：The method "+name+" begin with args "+ Arrays.asList(args));
    }
}
