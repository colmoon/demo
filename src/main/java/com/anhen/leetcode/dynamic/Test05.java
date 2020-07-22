package com.anhen.leetcode.dynamic;


/**
 * @classname: Test05
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: wuxiaojian
 * @create: 2020-06-06 09:18
 */
public class Test05 {
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(longestPalindrome3(s));
    }


    //暴力解法 时间o(n3) 空间无
    public static String longestPalindrome(String s) {
        int length = 0, index = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = s.length() - 1; j >= i; j--){
                int m = i, n = j;
                boolean flag = false;
                while (s.charAt(m) == s.charAt(n)){
                    if (m == n || m == n - 1){
                        flag = true;
                        break;
                    } else {
                        m++;
                        n--;
                    }
                }
                if (flag){
                    if ((j - i + 1) > length){
                        length = j - i + 1;
                        index = i;
                    }
                    break;
                }
            }
        }
        return s.substring(index,  index + length);
    }

    /* 动态规划
    p[i,j] = true,表示如果子串 Si... Sj 是回文串，否则为false
    状态转移方程
    p[i,j] = p[i+1,j-1] && (s[i] == s[j])
    边界条件
    p[i,i] = true, p[i,i+1] = (s[i] == s[i+1])
    转移过程中，从长度较短的字符串向长度较长的字符串进行转移
    */
    public static String longestPalindrome2(String s) {
        if (s.length() < 2){
            return s;
        }
        int length = 1, begin = 0;
        //初始化状态,
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        //填表规则：先填左下角，因为 i 一定小于 j，实际数组只有一半有值
        //填表规则：先一列一列的填写，再一行行填写
        for (int j = 1; j < s.length(); j++){
            for (int i = 0; i < j; i++){
                if (s.charAt(i) == s.charAt(j)){
                    //考虑头尾相等后没有字符串剩余，或者剩余一个字符串时，肯定是回文串
                    if (j - i < 3){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j -i + 1 > length){
                    length = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + length);
    }

    //中心扩展算法
    public static String longestPalindrome3(String s) {
        if (s.length() < 2){
            return s;
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int lenOdd = expandAroundCenter(s, i, i);
            int lenEven = expandAroundCenter(s, i, i + 1);
            int result = Math.max(lenOdd, lenEven);
            if (result > end - start){
                start = i - (result - 1)/2;
                end = i + result/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left + 1 - 2;
    }

}
