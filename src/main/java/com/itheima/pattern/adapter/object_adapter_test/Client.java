package com.itheima.pattern.adapter.object_adapter_test;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Adapter adapter = new Adapter(new TFCardImpl());
        String msg = computer.readSD(adapter);
        System.out.println(msg);
        System.out.println("hello");
    }
}
