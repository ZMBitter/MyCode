package com.zm.aop.notice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

/* 将一个类声明为一个切面
*   1. 把该类放入IOC容器中
*   2. 声明为一个切面
* */
@Order(2)  //使用@Order设置优先级
@Component
@Aspect
public class LoggingAspect {

    //声明该方法是一个前置通知：在目标方法开始之前执行。在另一个
    // 类中使用切入点表达式
    @Before("com.zm.aop.notice.ValidationAspect.declareJoinPointExcepression()")
    public void beforMethod(JoinPoint point){
        //获取所调用的目标方法的方法名
        String methodName = point.getSignature().getName();
       //获取传入的参数信息
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("前置切面：The method "+methodName+" starts with args "+args);
    }

    //后置通知：在目标方法执行之后执行,无论方法是否出现异常。不能访问返回值
    @After("execution(public void com.zm.aop.notice.ArithmeticDAO.plus(int,int))")
    public void afterMethod(JoinPoint point){
        //使用JoinPoint得到方法细节
        String name = point.getSignature().getName();
        Object[] args = point.getArgs();
        System.out.println("后置通知:The method "+name +"after with args "+Arrays.asList(args));
    }

    //返回通知：在方法正常结束后执行的代码，可以访问到方法的返回值
    @AfterReturning(value = "execution(* com.zm.aop.notice.ArithmeticDAO.sub(int,int))",returning = "result")
    public void afterReturnMethod(JoinPoint point,Object result){
        //使用JoinPoint得到方法细节
        String name = point.getSignature().getName();
        Object[] args = point.getArgs();
        System.out.println("返回通知:The method "+name +"afterReturning with args "+Arrays.asList(args)+" and ends is "+result);
    }

    //异常通知：在方法抛出（指定）异常时执行的代码。
    @AfterThrowing(value = "execution(public int com.zm.aop.notice.ArithmeticDAO.div(int,int))",throwing = "ex")
    public void afterThrowMethod(JoinPoint point,Exception ex){
        String name = point.getSignature().getName(); //目标方法名
        Object[] args = point.getArgs(); //目标方法中传入的参数
        System.out.println("异常通知：The method "+name +" occurs with "+Arrays.asList(args)+" and occurs with "+ex.getMessage());
    }

    /* 环绕通知：
    *   1. 类似于动态代理的全过程
    *   2.环绕通知必须携带 ProceedingJoinPoint 类型的参数，它可以决定是否执行目标方法
    *   3. 环绕通知必须有返回值，且返回值即为目标方法的返回值
    * */
    @Around(value = "execution(* com.zm.aop.notice.ArithmeticDAO.div(int,int))")
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
            System.out.println("异常通知：The method "+name+ "exception msg is"+e.getMessage()+" and result is "+result+" and occurs with "+e.getMessage());
        }

        //后置通知
        System.out.println("后置通知:The method "+name +" ends");
        return result;
    }
}
