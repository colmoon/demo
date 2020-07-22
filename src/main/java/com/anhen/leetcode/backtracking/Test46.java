package com.anhen.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: Test46
 * @description:
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
 *
 * @author: wuxiaojian
 * @create: 2020-07-03 18:14
 */
public class Test46 {

    public static void main(String[] args) {
        Test46 test46 = new Test46();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = test46.permute(nums);
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        bracket(result, tempList, nums);
        return result;
    }

    //回溯
    private void bracket(List<List<Integer>> result, List<Integer> tempList, int[] nums){
        if (tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) {
                    continue;
                }
                tempList.add(num);
                bracket(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
