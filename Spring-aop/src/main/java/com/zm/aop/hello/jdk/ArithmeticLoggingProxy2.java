package com.zm.aop.hello.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticLoggingProxy2 {
    private ArithmeticDAO target;  //需要被代理的对象

    public ArithmeticLoggingProxy2(ArithmeticDAO target) {
        this.target = target;
    }

    public ArithmeticDAO getLoggingProxy(){
        ArithmeticDAO proxy = null;  //代理对象
        //指定代理对象由哪一个类加载器加载
        ClassLoader loader = target.getClass().getClassLoader();
        //需要代理对象实现的数组，里面保存的是代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticDAO.class};
        /*
         调用代理对象中的方法时，应该执行的代码。InvocationHandler 调用处理器
        Object proxy：代理对象
        Method method：正在被调用的方法
        Object[] args：调用方法时，传入的参数
        */
        InvocationHandler invoke = new InvocationHandler () {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName();
                System.out.println(name+" start……"+ Arrays.asList(args));
                Object result = method.invoke(target, args);
                System.out.println(name+" end……");
                return result;
            }
        };
        proxy = (ArithmeticDAO) Proxy.newProxyInstance(target.getClass().getClassLoader(),interfaces ,invoke);
        return proxy;
    }
}
