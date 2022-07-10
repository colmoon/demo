package com.moon.demo.design.design.chapter21.composite;

/**
 * @classname: Client
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-06 16:36
 */
public class Client {
    public static void main(String[] args) {
        //创建一个根节点
        Composite root = new Composite();
        root.doSomething();
        //创建一个树枝构件
        Composite branch = new Composite();
        //创建一个叶子构件
        Leaf leaf = new Leaf();
        //建立整体
        root.add(branch);
        branch.add(leaf);
    }

    public static void disPlay(Composite root){
        for (Component component : root.getChildren()){
            if (component instanceof Leaf){
                component.doSomething();
            } else {
                disPlay((Composite) component);
            }
        }
    }
}
