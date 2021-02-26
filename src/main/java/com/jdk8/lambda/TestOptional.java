package com.jdk8.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * @ClassName TestOptional
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/16 14:12
 * @Version 1.0
 **/

public class TestOptional {
    public static void main(String[] args){

        TestOptional testOptional = new TestOptional();
        Integer value1 = null;
        Integer value2 = 10;

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.empty();

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(testOptional.sum(a,b));
//        User user = null;
        User user = new User("Tom");
        System.out.println(getUserName(user));
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b){

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent() + a.orElse(2));
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(0);

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.orElse(0);
        return value1 + value2;
    }

    private static String getUserName(User user){
        return Optional.ofNullable(user).map(User::getName).orElse("Unknown");
    }

    @Data
    @AllArgsConstructor
    private static class User{
        private String name;
    }
}
