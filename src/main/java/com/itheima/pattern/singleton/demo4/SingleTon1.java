package com.itheima.pattern.singleton.demo4;

public class SingleTon1 {
    private SingleTon1(){

    }
    private static volatile SingleTon1 instance;
    public SingleTon1 getInstance(){
        if(instance == null){
            synchronized (this){
                if(instance == null){
                    instance = new SingleTon1();
                }
            }
        }
        return instance;
    }
}
