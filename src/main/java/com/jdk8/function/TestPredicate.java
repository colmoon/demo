package com.jdk8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @ClassName TestPredicate
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/23 18:32
 * @Version 1.0
 **/

public class TestPredicate {
    public static void main(String[] args) {
        int[] numbers= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        List<Integer> list=new ArrayList<>();
        for(int i:numbers) {
            list.add(i);
        }
        Predicate<Integer> p1 = i -> i > 5;
        Predicate<Integer> p2 = i -> i < 20;
        Predicate<Integer> p3 = i -> i % 2 == 0;
        List test = list.stream().filter(p1.and(p2).and(p3)).collect(Collectors.toList());
        System.out.println(test.toString());
/** print:[6, 8, 10, 12, 14]*/
    }
}
