package com.anhen.leetcode.binary.search;

import java.util.Arrays;

/**
 * @classname: Test34
 * @description:
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
 *
 * @author: wuxiaojian
 * @create: 2020-07-08 18:00
 */
public class Test34 {
    public static void main(String[] args) {
        Test34 test34 = new Test34();
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] ints = test34.searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }


    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums == null || nums.length == 0){
            return result;
        }
        result[0] = leftBound(nums, target);
        result[1] = rightBound(nums, target);
        return result;
    }

    //递归
    private int search(int[] nums, int low, int high, int target){
        if (low > high){
            return -1;
        }
        int mid = low + (high - low)/2;
        if (nums[mid] == target){
            return mid;
        } else if (nums[mid] < target){
            return search(nums, mid + 1, high, target);
        } else {
            return search(nums, low, mid - 1, target);
        }
    }

    //循环
    private int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }

    //寻找左侧边界的二分查找法
    private int leftBound(int[] nums, int target){
        if (nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                //收缩右侧边界
                right = mid - 1;
            } else if (nums[mid] < target){
                // 搜索区间为 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target){
                // 搜索区间为 [left, mid - 1]
                right = mid - 1;
            }
        }
        // 检查出界条件
        if (left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    //寻找右侧边界的二分查找法
    private int rightBound(int[] nums, int target){
        if (nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                // 收缩左侧边界
                left = mid + 1;
            } else if (nums[mid] < target){
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        // 检查出界条件
        if (right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }
}
