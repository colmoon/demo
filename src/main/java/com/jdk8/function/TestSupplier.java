package com.jdk8.function;

import java.util.function.Supplier;

/**
 * @ClassName Supplier
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/16 10:41
 * @Version 1.0
 **/

public class TestSupplier {
    public static void main(String[] args) {
        // 创建字符串
        String str = "hello world";

        // 调用
        String sup = testSup(() -> str);

        System.out.println(sup);
    }

    /**
     *
     * @param sup
     * @return
     */
    public static <T> T testSup(Supplier<T> sup) {
        // 执行
        return sup.get();
    }
}
