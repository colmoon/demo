package com.moon.demo.service.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
 
/**
 * @author wuxiaojian
 */
public class Test3 {
 
    public static void main(String[] args) {
        map();
    }
 
    public static void map() {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        cost.stream().map(x -> x + x * 0.05).forEach(System.out::println);
    }
}