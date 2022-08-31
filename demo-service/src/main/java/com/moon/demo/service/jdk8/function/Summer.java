package com.moon.demo.service.jdk8.function;

import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * @classname: Summer
 * @description: 将ints和doubles两个数组内为偶数（或四舍五入后是偶数）的元素累加
 * @author: wuxiaojian
 * @create: 2022-08-31 21:42
 */

public class Summer<T extends Number> {



    public T sum(T zeroValue, T[] numbers, Predicate<T> predicate, BiFunction<T, T, T> accumulate) {
        for (T t : numbers){
            if (predicate.test(t)){
                zeroValue = accumulate.apply(zeroValue, t);
            }
        }
        return zeroValue;
    }

    public static void main(String[] args) {
        Summer<Integer> integerSummer = new Summer<>();
        Integer[] ints = new Integer[] {1, 2, 3, 8};
        System.out.println(integerSummer.sum(0, ints, i -> i % 2 == 0, Integer::sum));

        Summer<Double> doubleSummer = new Summer<>();
        Double[] doubles = new Double[]{1.2, 2.3, 2.8, 4.54};
        System.out.println(doubleSummer.sum(0.0, doubles, i -> Math.round(i) % 2 ==0, Double::sum));
    }

}
