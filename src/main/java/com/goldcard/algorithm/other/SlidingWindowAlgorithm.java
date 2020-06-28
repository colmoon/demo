package com.goldcard.algorithm.other;

/**
 * @ClassName SlidingWindowAlgorithm
 * @Description 滑动窗算法
 * @Author wuxiaojian
 * @Date 2019/9/2 9:18
 * @Version 1.0
 **/

public class SlidingWindowAlgorithm {

    private static int maxSum(int[] array, int k, int n){
        if (k > n){
            System.out.println("error");
            return 0;
        }
        int maxSum = 0;
        for (int i = 0; i < k; i++){
            maxSum += array[i];
        }
        int windowSum = maxSum;
        for (int i = k; i < n; i++){
            windowSum += array[i] - array[i - k];
            maxSum = Math.max(windowSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        //滑动窗大小
        int k = 4;
        int n = array.length;
        int sum = maxSum(array, k, n);
        System.out.println(sum);
    }
}
