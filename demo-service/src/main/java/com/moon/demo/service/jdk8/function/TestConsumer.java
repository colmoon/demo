package com.moon.demo.service.jdk8.function;

import java.util.function.Consumer;

/**
 * @ClassName TestConsumer
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/16 10:46
 * @Version 1.0
 **/

public class TestConsumer {
    public static void main(String[] args) {
        // 创建字符串
        String str = "hello world";

        // 调用
        testCon(str, System.out::println);

        TestFunction.printer((s) -> "Length is " + s.length(), "abc");
    }

    /**
     *
     * @param str 传入参数
     * @param con
     */
    public static <T> void testCon(T str, Consumer<T> con) {
        // 执行
        con.accept(str);
    }
}
