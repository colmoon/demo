package com.moon.demo.algorithm.chapter1;

import java.util.Arrays;

/**
 * @ClassName TwoSumFast
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/30 21:17
 * @Version 1.0
 **/

public class TwoSumFast {
    public static int count(int[] a){
        Arrays.sort(a);
        int count = 0;
        int length = a.length;
        for (int i = 0; i < length; i++){
            int j = BinarySearch.indexOf(a,-a[i]);
            if (j > i){
                count++;
            }
        }
        return count;
    }
}
