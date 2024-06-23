package com.itheima.pattern.singleton.demo1;

public class SingleTon1 {
    private SingleTon1(){

    }
    private static SingleTon1 singleTon1 = new SingleTon1();
    public static SingleTon1 getInstance(){
        return singleTon1;
    }
}
