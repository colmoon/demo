package com.anhen.leetcode;

/**
 * @classname: Test11
 * @description:
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: wuxiaojian
 * @create: 2020-06-10 11:48
 */
public class Test11 {

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(a));
    }

    //暴力循环 O(n2)
    public static int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++){
            for (int j = i + 1; j < height.length;j++){
                int min = Math.min(height[i], height[j]);
                result = Math.max(result, min * (j-i));
            }
        }
        return result;
    }

    //双指针 O(n1)
    public static int maxArea2(int[] height) {
        int result = 0;
        int leftCursor = 0, rightCursor = height.length - 1;
        while (leftCursor < rightCursor){
            result = Math.max(result, Math.min(height[leftCursor], height[rightCursor]) * (rightCursor - leftCursor));
            if (height[leftCursor] < height[rightCursor]){
                leftCursor++;
            } else {
                rightCursor--;
            }
        }
        return result;
    }
}
