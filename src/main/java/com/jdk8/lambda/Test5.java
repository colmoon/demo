package com.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
 
public class Test5 {
 
    public static void main(String[] args) {
        filter();
    }
    public static void filter() {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0, 40.0);
        List<Double> filteredCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(System.out::println);
    }
}