package com.goldcard.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName RoundRobin
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/7/10 9:32
 * @Version 1.0
 **/

public class RoundRobin {
    private final static AtomicInteger next = new AtomicInteger(0);

    public int select(int[] s) throws Exception{
        if (s == null || s.length == 0){
            throw new IllegalArgumentException();
        } else {
            return s[next.getAndIncrement() % s.length];
        }
    }

    public static void main(String[] args) throws Exception{
        int[] array = new int[]{1,2,3,4,5};
        RoundRobin roundRobin = new RoundRobin();
        for (int i = 0; i < 10; i++){
            System.out.println(roundRobin.select(array));
        }
    }
}
