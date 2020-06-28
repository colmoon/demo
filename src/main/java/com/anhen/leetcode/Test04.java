package com.anhen.leetcode;

/**
 * @classname: Test04
 * @description:
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 * @author: wuxiaojian
 * @create: 2020-06-05 15:44
 */
public class Test04 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int i = 0, j = 0, k = 0;
        int[] temp = new int[nums1.length + nums2.length];
        while (i < nums1.length || j < nums2.length){
            if (i < nums1.length && j < nums2.length){
                if (nums1[i] <= nums2[j]){
                    temp[k++] = nums1[i];
                    i++;
                } else {
                    temp[k++] = nums2[j];
                    j++;
                }
            } else if (i < nums1.length){
                temp[k++] = nums1[i];
                i++;
            } else {
                temp[k++] = nums2[j];
                j++;
            }
        }
        if (temp.length % 2 == 0){
            result = (temp[temp.length/2 -1] + temp[temp.length/2])/2.0;
        } else {
            result = temp[temp.length/2];
        }
        return result;
    }
}
