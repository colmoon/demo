package com.moon.demo.service.jdk8.tuple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName Tuple
 * @Description 二元组
 * @Author wuxiaojian
 * @Date 2019/5/28 13:47
 * @Version 1.0
 **/

public interface Tuple<K, V> {
    //根据下标获取元素
    Object get(int i);

    //
    static <K,V> Tuple<K, V> tuple(K k, V v){
        return i -> i == 0 ? k:v;
//        return new Tuple<K, V>() {
//            @Override
//            public Object get(int i) {
//                return i == 0 ? k:v;
//            }
//        };
    }

    //获取元组的第一个元素
    default K getKey(){
        return (K)get(0);
    }

    //获取元组的第二个元素
    default V getValue(){
        return (V)get(1);
    }

    //元组数组转HashMap，可以指定map类型
    static <K, V> Map<K, V> map(Tuple<K, V>... tuples){
        return mapNew(HashMap::new, tuples);
    }

    //创建map
    static <K, V> Map<K, V> mapNew(Function<Integer, ? extends Map<K,V>> function, Tuple<K, V>... tuples){
        return Arrays.stream(tuples).collect(Collectors.toMap(
                Tuple::getKey,
                Tuple::getValue,
                (a,b)->b,
                ()->function.apply(tuples.length)));
    }


}
