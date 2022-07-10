package com.moon.demo.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @classname: Test56
 * @description:
 *
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 * @author: wuxiaojian
 * @create: 2020-07-21 19:56
 */
public class Test56 {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 遍历区间
        int[][] result = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals){
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > result[idx][1]){
                result[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                result[idx][1] = Math.max(interval[1], result[idx][1]);
            }
        }
        return Arrays.copyOf(result, idx + 1);
    }
}

