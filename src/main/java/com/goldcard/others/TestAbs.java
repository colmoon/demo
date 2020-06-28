package com.goldcard.others;

import java.util.HashMap;

/**
 * @ClassName TestAbs
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2019/2/14 16:59
 */
public class TestAbs {

    public static void main(String[] args) {
        int key2 = Math.abs(Integer.MIN_VALUE);
        long key1 = Math.abs(Integer.MIN_VALUE);
        int key = 1 & Integer.MAX_VALUE;
        System.out.println(key);

        HashMap<String, String> hashMap = new HashMap<>();
    }
}
