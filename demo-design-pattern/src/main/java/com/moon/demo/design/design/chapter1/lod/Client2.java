package com.moon.demo.design.design.chapter1.lod;

/**
 * @ClassName Client2
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2021/10/10 10:40
 * @Version 1.0
 **/

public class Client2 {
    public static void main(String[] args) {
        InstallSoftware invoker = new InstallSoftware();
        invoker.installWizard(new Wizard());
    }
}
