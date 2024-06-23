package com.itheima.pattern.proxy.cglib_proxy_test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new TrainStation());
        TrainStation proxyObject = (TrainStation)proxyFactory.getProxyObject();
        proxyObject.sell();
    }
    public Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }
    public Object getProxyObject(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        Object proxyObject = enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代售点收取费用");
        Object result = method.invoke(target, objects);
        return result;
    }
}
