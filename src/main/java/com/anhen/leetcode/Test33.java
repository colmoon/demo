package com.anhen.leetcode;

/**
 * @ClassName Test33
 * @Description
 *
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 *
 * 题目要求算法时间复杂度必须是 O(\log n)O(logn) 的级别，这提示我们可以使用二分搜索的方法。
 *
 * 但是数组本身不是有序的，进行旋转后只保证了数组的局部是有序的，这还能进行二分搜索吗？答案是可以的。
 *
 * 可以发现的是，我们将数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的。拿示例来看，我们从 6 这个位置分开以后数组变成了 [4, 5, 6] 和 [7, 0, 1, 2] 两个部分，其中左边 [4, 5, 6] 这个部分的数组是有序的，其他也是如此。
 *
 * 这启示我们可以在常规二分搜索的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，并根据有序的那个部分确定我们该如何改变二分搜索的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分：
 *
 * 如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [\textit{nums}[l],\textit{nums}[mid])[nums[l],nums[mid])，则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。
 * 如果 [mid, r] 是有序数组，且 target 的大小满足 (\textit{nums}[mid+1],\textit{nums}[r]](nums[mid+1],nums[r]]，则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Author wuxiaojian
 * @Date 2020/7/6 22:10
 * @Version 1.0
 **/

public class Test33 {
    public static void main(String[] args) {
        Test33 test33 = new Test33();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int search = test33.search(nums, 0);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        if ( nums == null || nums.length == 0){
            return -1;
        }
        return search2(nums, 0, nums.length - 1, target);
    }

    //递归
    private int search(int[] nums, int low, int high, int target){
        if (low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target){
            return mid;
        }
        if (nums[mid] < nums[high]){
            //右边有序
            if (nums[mid] < target && target <= nums[high]){
                return search(nums, mid + 1, high, target);
            } else {
                return search(nums, low, mid - 1, target);
            }
        } else {
            //左边有序
            if (nums[mid] > target && target >= nums[low]){
                return search(nums, low, mid - 1, target);
            } else {
                return search(nums, mid + 1, high, target);
            }
        }
    }

    //迭代
    private int search2(int[] nums, int low, int high, int target){
        while (low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < nums[high]){
                //右边有序
                if (nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                //左边有序
                if (nums[mid] > target && target >= nums[low]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}
