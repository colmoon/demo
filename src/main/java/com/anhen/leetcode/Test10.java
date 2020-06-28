package com.anhen.leetcode;

/**
 * @classname: Test10
 * @description: 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: wuxiaojian
 * @create: 2020-06-06 16:20
 */
public class Test10 {

    public static void main(String[] args) {
        System.out.println(isMatch2("aaa","a*a"));
        System.out.println(isMatch2("ab",".*c"));
        System.out.println(isMatch2("aa","a"));
        System.out.println(isMatch2("aa","a*"));
        System.out.println(isMatch2("ab",".*"));
        System.out.println(isMatch2("aab","c*a*b"));
        System.out.println(isMatch2("mississippi","mis*is*p*."));
    }

    //自己写尚未通过
    public static boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()){
            if (s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            } else {
                if (p.charAt(j) == '.'){
                    i++;
                    j++;
                } else if (p.charAt(j) == '*'){
                    if (j >= 1){
                        while (i < s.length() && (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.')){
                            i++;
                        }
                        j++;
                    } else {
                        j++;
                    }
                } else if (j+1 < p.length() && p.charAt(j+1) == '*'){
                    j = j + 2;
                } else {
                    return false;
                }
            }
        }
        return i >= s.length() && j >= p.length();
    }

    /*动态规划
    p[i,j] = true 表示 s的 i 个字符串与 p 的 j 个字符串匹配
    */
    public static boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true; // here's y axis should be i+1
            }
        }
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*'){
                    if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i)){
                        dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
