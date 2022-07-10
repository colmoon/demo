package com.moon.demo.service.jdk8.tuple;

import javafx.util.Pair;

/**
 * @ClassName TestPair
 * @Description pair 键值对
 * @Author wuxiaojian
 * @Date 2019/6/10 10:44
 * @Version 1.0
 **/

public class TestPair {
    Pair<Integer, String> pair = new Pair<>(1,"Monday");
    Integer key = pair.getKey();
    String value = pair.getValue();
}
