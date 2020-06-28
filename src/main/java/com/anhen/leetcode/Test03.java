package com.anhen.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @classname: Test03
 * @description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: wuxiaojian
 * @create: 2020-06-04 18:33
 */
public class Test03 {
    public static void main(String[] args) {
        String string = "aab";
        String string2 = "bbbbbbbb";
        String string3 = "pwwkew";
        String string4 = "au";
        String string5 = "dvdf";
        System.out.println(lengthOfLongestSubstring2(string));
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int result = 1;
        int count = 0;
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < charArray.length; ){
            if (!hashMap.containsKey(charArray[i])){
                hashMap.put(charArray[i], i);
                count++;
                i++;
            } else {
                int index = hashMap.get(charArray[i]);
                hashMap.clear();
                count = 0;
                i = index + 1;
            }
            if (count > result){
                result = count;
            }
        }
        return result;
    }

    //官方写法，滑动窗
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> hashSet = new HashSet<>();
        int rightCursor = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            if (i != 0){
                hashSet.remove(s.charAt(i - 1));
            }
            while (rightCursor < s.length() && !hashSet.contains(s.charAt(rightCursor))){
                hashSet.add(s.charAt(rightCursor));
                rightCursor++;
            }
            result = Math.max(result, rightCursor - i);
        }
        return result;
    }
}
