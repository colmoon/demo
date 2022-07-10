package com.moon.demo.service.jdk8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName MaxMin
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/16 10:56
 * @Version 1.0
 **/

public class MaxMin {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("abc");
        list.add("ab");
        list.add("abcd");
        list.add("abcde");

        // 获取最大值
        int max = list.stream().map(String::length).max(Integer :: compareTo).orElse(0);
        System.out.println(max);

        // 获取最小值，另一种方法
        int min = list.stream().min(Comparator.comparing(String::length)).orElse("").length();
        System.out.println(min);
    }
}
