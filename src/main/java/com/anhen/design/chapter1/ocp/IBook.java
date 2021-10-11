package com.anhen.design.chapter1.ocp;

public interface IBook {
    //书籍有名称
    String getName();

    //书籍有售价
    int getPrice();

    //打折
    default double getOffPrice(){
        return getPrice() * 0.9;
    }

    //书籍有作者
    String getAuthor();
}