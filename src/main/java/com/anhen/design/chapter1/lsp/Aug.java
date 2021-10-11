package com.anhen.design.chapter1.lsp;

/**
 * @author wuxiaojian
 */
public class Aug extends Rifle {

    /**
     * 狙击枪都携带一个精准的望远镜
     * @return: void
     **/
    public void zoomOut() {
        System.out.println("通过望远镜察看敌人...");
    }

    @Override
    public void shoot() {
        System.out.println("AUG射击...");
    }
}