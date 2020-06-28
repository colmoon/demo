package com.jdk8.function;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName ConvertMapToList
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/3/30 15:12
 * @Version 1.0
 **/

public class ConvertMapToList {
    public static void main(String[] args) {
        testMapToList2();
//        HashMap<String,String> hashMap = new HashMap<>();
//        hashMap.put("wu","qwe");
//        hashMap.put("zhang","asd");
//        String jsonString = JSON.toJSONString(hashMap);
//        System.out.println("json字符串是："+jsonString);
    }
    
    /**
     * @Author wuxiaojian
     * @Description //TODO 
     * @Date 15:14 2019/3/30
     * @Param []
     * @return void
     **/
    public static void testMapToList1(){
        Map<Integer, String> map = new HashMap<>(8);
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");
        System.out.println("\n1. Export Map Key to List...");
        List<Integer> result = new ArrayList<>(map.keySet());
        result.forEach(System.out::println);
        System.out.println("\n2. Export Map Value to List...");
        List<String> result2 = new ArrayList<>(map.values());
        result2.forEach(System.out::println);
        System.out.println("\n3. Export Map Value to List..., say no to banana");
        List<String> result3 = map.values().stream()
                .filter(x-> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());
        result3.forEach(System.out::println);
    }

    /**
     * @Author wuxiaojian
     * @Description //TODO 
     * @Date  2019/3/30 15:39
     * @Param []
     * @return void
     **/
    public static void testMapToList2() {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");
        // split a map into 2 List
        List<Integer> resultSortedKey = new ArrayList<>();
        //map函数可以说是函数式编程里最重要的一个方法了。map的作用是将一个对象变换为另外一个。
        //peek: 生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），->
        // 新Stream每个元素被消费的时候都会执行给定的消费函数；
        List<String> resultValues = map.entrySet().stream()
                //sort a Map by key and stored in resultSortedKey
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(e -> resultSortedKey.add(e.getKey()))
                .map(Map.Entry::getValue)
                // filter banana and return it to resultValues
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());
        resultSortedKey.forEach(System.out::println);
        resultValues.forEach(System.out::println);

        System.out.println("*********************************");
        map.forEach(((integer, s) -> {
            if (integer > 30){
                System.out.println(s);
            } else {
                return;
            }
            System.out.println(integer);
        }));
    }

}
