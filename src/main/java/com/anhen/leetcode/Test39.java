package com.anhen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: Test39 组合求和
 * @description:
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: wuxiaojian
 * @create: 2020-07-06 19:36
 */
public class Test39 {

    public static void main(String[] args) {
        Test39 test39 = new Test39();
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> permute = test39.combinationSum(candidates, target);
        System.out.println(permute);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int start = 0;
        bracket(result, tempList, candidates, start, target);
        return result;
    }

    //回溯
    private void bracket(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int start, int target){
        if (target == 0){
            result.add(new ArrayList<>(tempList));
        } else if (target > 0){
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                bracket(result, tempList, candidates, i, target- candidates[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
