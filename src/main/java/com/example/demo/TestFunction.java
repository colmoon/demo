package com.example.demo;

import java.util.function.Function;

/**
 * @ClassName TestFunction
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/1 13:47
 * @Version 1.0
 **/

public class TestFunction {
    public static void main(String[] args) {
        Function<Integer,Integer> A=i->i+1;
        Function<Integer,Integer> B=i->i*i;
        System.out.println("F1:"+B.apply(A.apply(5)));
        System.out.println("F1:"+B.compose(A).apply(5));
        System.out.println("F2:"+A.apply(B.apply(5)));
        System.out.println("F2:"+B.andThen(A).apply(5));
    }

    public static Integer calculate(Function<Integer,Integer> test,Integer number){
        return test.apply(number);
    }
}
