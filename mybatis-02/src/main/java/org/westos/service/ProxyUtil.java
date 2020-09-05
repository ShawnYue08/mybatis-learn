package org.westos.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lwj
 * @date 2020/9/5 17:20
 */
public class ProxyUtil implements InvocationHandler {
    private Object obj;
    //被代理类对象

    public ProxyUtil(Object obj) {
        this.obj = obj;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                this);
        //第三个参数为InvocationHandler接口的实现类对象
    }

    /**
     * 当访问被代理类的方法时，程序来到该invoke()方法处
     * @param proxy 代理对象
     * @param method 方法对象
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        //动态代理，来增强被代理类的方法逻辑
        long start = System.currentTimeMillis();
        result = method.invoke(obj, args);
        //执行被代理类的方法
        long end = System.currentTimeMillis();
        System.out.println("程序耗时" + (end - start) / 1000 + "s.");
        return result;
    }
}
