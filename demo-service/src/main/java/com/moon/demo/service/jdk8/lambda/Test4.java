package com.moon.demo.service.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
 
/**
 * @author wuxiaojian
 */
public class Test4 {
 
    public static void main(String[] args) {
        mapReduce();
    }
 
    public static void mapReduce() {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        double allCost = cost.stream().map(x -> x + x * 0.05).reduce(Double::sum).get();
        System.out.println(allCost);
    }
}