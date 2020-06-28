package com.study;

/**
 * @ClassName Test
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/8/8 10:29
 * @Version 1.0
 **/

public class Test {
    public static void main(String[] args) {
        String s1 = new String("hello") + new String("world");
        System.out.println(s1.intern() == s1);
        String s2 = new String("hello") + new String("world");
        System.out.println(s2.intern() == s2);
    }
}
