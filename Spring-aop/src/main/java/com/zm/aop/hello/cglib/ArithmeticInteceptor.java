package com.zm.aop.hello.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/* CGLib动态代理方式实现 */
public class ArithmeticInteceptor implements MethodInterceptor {

    /*
      Object o：代理对象
      Method method：正在调用的方法
      Object[] args：目标方法的形参
      MethodProxy proxyMethod：代理方法
    */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy proxyMethod) throws Throwable {
        Object result = null;
        String name = method.getName();
        System.out.println(name+" start……"+ Arrays.asList(args));
        try{
            result = proxyMethod.invokeSuper(proxy,args);
            // result = method.invoke(proxy,args);
        }catch (Exception e){
            System.out.println("异常信息："+e.getMessage());
        }finally {
            System.out.println(name+" end……");
        }
        return null;
    }


}
