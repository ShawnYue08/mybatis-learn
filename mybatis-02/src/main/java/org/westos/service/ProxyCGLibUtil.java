package org.westos.service;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lwj
 * @date 2020/9/5 17:41
 */
public class ProxyCGLibUtil implements Callback {
    private Object obj;
    //目标类对象

    public ProxyCGLibUtil(Object obj) {
        this.obj = obj;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        //代理类要继承obj的类
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //o表示代理对象，method表示目标类中的方法，args表示方法参数，proxy表示代理方法的MethodProxy对象
                return methodProxy.invokeSuper(o, objects);
            }
        });
        return enhancer.create();
        //生成动态代理类
    }
}
