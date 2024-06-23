package com.itheima.pattern.adapter.object_adapter_test;

public class Adapter implements SDCard{
    private TFCard tfCard;
    public Adapter(TFCard tfCard){
        this.tfCard = tfCard;
    }
    @Override
    public String readSD() {
        System.out.println("适配器读取tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("适配器写入tf card");
        tfCard.readTF();
    }
}
