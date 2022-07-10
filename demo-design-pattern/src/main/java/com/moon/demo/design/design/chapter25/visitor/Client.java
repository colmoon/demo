package com.moon.demo.design.design.chapter25.visitor;

/**
 * @classname: Client
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-11 19:12
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            //获得元素
            Element element = ObjectStructure.createElement();
            element.accept(new Visitor());
        }
    }
}
