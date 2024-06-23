package com.itheima.pattern.singleton.demo5;

public class SingleTon1 {
    private SingleTon1(){}
    private static class SingleHolder{
        private static final SingleTon1 INSTANCE= new SingleTon1();
    }
    public SingleTon1 getInstance(){
        return SingleHolder.INSTANCE;
    }
}
