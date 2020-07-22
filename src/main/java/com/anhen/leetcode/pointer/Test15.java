package com.anhen.leetcode.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @classname: Test15
 * @description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: wuxiaojian
 * @create: 2020-06-11 11:35
 */
public class Test15 {

    public static void main(String[] args) {
//        int[] nums = new int[]{-2,0,1,1,2};
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists.toString());
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2; i++){
            if(nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length -1;
            while(left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if (temp > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
