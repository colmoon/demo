package com.moon.demo.service.jdk8.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test2 {
 
    public static void main(String[] args) {
        // Java8之前：
        List<String> list1 = Arrays.asList("a", "b", "c", "d");
        for (String str : list1) {
            System.out.println(str);
        }
 
        // Java 8之后：
        List<String> list2 = Arrays.asList("a", "b", "c", "d");
        list2.forEach(System.out::println);
 
        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        list2.forEach(System.out::println);

        Stream<?> flatMap = Stream.of(Arrays.asList("a", "b"), Arrays.asList(1, 2, 3)).flatMap(Collection::stream);
        flatMap.forEach(System.out :: println);

        List<String> list = new ArrayList<>(Arrays.asList("I","love","you","too"));
        //匿名类
        list.forEach(new Consumer<String>(){
            @Override
            public void accept(String str){
                if(str.length() > 3) {
                    System.out.println(str);
                }
            }
        });
        //lambda表达式
        list.forEach(str->{
            if (str.length() > 3){
                System.out.println(str);
            }
        });
//        list.removeIf(str->str.length()>3);
        list.replaceAll(String::toUpperCase);
        list.forEach(System.out :: println);
        list.sort(Comparator.comparing(String::length));

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println(map.getOrDefault(4,"noValue"));
        System.out.println(map.putIfAbsent(4,"four"));
        System.out.println(map.remove(4,"four"));
        map.replaceAll((k,v)->v.toUpperCase());

        map.forEach((k,v)-> System.out.println(k + " = " + v));

        Stream<String> stringStream = Stream.of("I","love","you","too");
        stringStream.filter(str->str.length() > 3).forEach(System.out :: println);
    }
}