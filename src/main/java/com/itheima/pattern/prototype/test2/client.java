package com.itheima.pattern.prototype.test2;


public class client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation();
        Citation citation1 = citation.clone();

        citation.setName("liudingyu");
        citation1.setName("liudingyu1");

        citation.show();
        citation1.show();
    }
}
