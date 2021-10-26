package com.anhen.design.chapter16.chain.instance;

public interface IWomen {
    //获得个人状况
    int getType();

    //获得个人请示， 你要干什么？ 出去逛街？ 约会?还是看电影？
    String getRequest();
}