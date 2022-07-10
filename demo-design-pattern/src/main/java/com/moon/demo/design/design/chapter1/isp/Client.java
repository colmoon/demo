package com.moon.demo.design.design.chapter1.isp;

public class Client {
    //搜索并展示美女信息
    public static void main(String[] args) {
        //定义一个美女
        IGoodBodyGirl yanYan = new PettyGirl("嫣嫣");
        AbstractSearcher searcher = new Searcher(yanYan);
        searcher.show();
    }
}