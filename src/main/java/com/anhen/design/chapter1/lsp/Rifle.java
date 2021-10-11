package com.anhen.design.chapter1.lsp;

/**
 * @author wuxiaojian
 */
public class Rifle extends AbstractGun {
    @Override
    public void shoot() {
        System.out.println("步枪射击...");
    }
}