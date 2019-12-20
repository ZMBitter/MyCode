package com.zm.aop.hello.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/*使用JDK动态代理实现在方法前后加入日志信息*/
public class ArithmeticLoggingProxy implements InvocationHandler{
    private ArithmeticDAO target;  //需要被代理的对象

    public ArithmeticLoggingProxy(ArithmeticDAO target) {
        this.target = target;
    }

    /*
       调用代理对象中的方法时，应该执行的代码。InvocationHandler 调用处理器
       Object proxy：代理对象
       Method method：正在被调用的方法
       Object[] args：调用方法时，传入的参数
       */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        String name = method.getName();
        System.out.println(name+" start……"+ Arrays.asList(args));
        try{
            result = method.invoke(target, args);
        }catch (Exception e){
            System.out.println("异常信息："+e.getMessage());
        }finally {
            System.out.println(name+" end……" );
        }
        return result;
    }
}
