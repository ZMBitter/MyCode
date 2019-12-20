package com.zm.aop.xmlnotice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import java.util.Arrays;
import java.util.List;

/* 将一个类声明为一个切面
*   1. 把该类放入IOC容器中
*   2. 声明为一个切面
* */
public class LoggingAspect {

    public void beforMethod(JoinPoint point){
        //获取所调用的目标方法的方法名
        String methodName = point.getSignature().getName();
       //获取传入的参数信息
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("前置切面：The method "+methodName+" starts with args "+args);
    }

    public void afterMethod(JoinPoint point){
        //使用JoinPoint得到方法细节
        String name = point.getSignature().getName();
        Object[] args = point.getArgs();
        System.out.println("后置通知:The method "+name +"after with args "+Arrays.asList(args));
    }

    public void afterReturnMethod(JoinPoint point,Object result){
        //使用JoinPoint得到方法细节
        String name = point.getSignature().getName();
        Object[] args = point.getArgs();
        System.out.println("返回通知:The method "+name +"afterReturning with args "+Arrays.asList(args)+" and ends is "+result);
    }

    public void afterThrowMethod(JoinPoint point,Exception ex){
        String name = point.getSignature().getName(); //目标方法名
        Object[] args = point.getArgs(); //目标方法中传入的参数
        System.out.println("异常通知：The method "+name +" with "+Arrays.asList(args)+"-"+ex.getMessage());
    }

    /* 环绕通知：
    *   1. 类似于动态代理的全过程
    *   2.环绕通知必须携带 ProceedingJoinPoint 类型的参数，它可以决定是否执行目标方法
    *   3. 环绕通知必须有返回值，且返回值即为目标方法的返回值
    * */
    public Object around(ProceedingJoinPoint pjp){
        Object result = null;  //结果

        String name = pjp.getSignature().getName(); //目标方法名
        Object[] args = pjp.getArgs(); //传入的参数

        try {
            //前置通知：
            System.out.println("前置通知：The method "+name+" starts with args "+Arrays.asList(args));
           //执行目标方法
            result = pjp.proceed();
            //返回通知
            System.out.println("返回通知：The method "+name+" result is "+result);
        } catch (Throwable e) {
            System.out.println("异常通知：The method "+name+ " exception msg is"+e.getMessage()+" and result is "+result);
        }

        //后置通知
        System.out.println("后置通知:The method "+name +" ends");
        return result;
    }
}
