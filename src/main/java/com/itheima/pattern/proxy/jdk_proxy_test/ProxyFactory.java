package com.itheima.pattern.proxy.jdk_proxy_test;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new TrainStation());
        SellTickets proxy = (SellTickets)proxyFactory.getProxyObject();
        proxy.sell();
        System.out.println(proxy.getClass());
        while (true){
        }
    }
    private Object target;
    public ProxyFactory(Object target) {
        this.target = target;
    }
    public Object getProxyObject(){
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代售点收取一定的服务费用(jdk动态代理)");
                        //目标对象执行方法
                        Object object = method.invoke(target, args);
                        return object;
                    }
                }
        );
        return proxy;
    }
}
