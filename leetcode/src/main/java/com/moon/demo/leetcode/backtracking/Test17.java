package com.moon.demo.leetcode.backtracking;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test17
 * @Description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author wuxiaojian
 * @Date 2020/6/13 10:53
 * @Version 1.0
 **/

public class Test17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    private static Map<String, String> phone = new HashMap<String, String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};
    private static List<String> result = new ArrayList<>();


    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return result;
        }
        backtrack("", digits);
        return result;
    }

    public static void backtrack(String combination, String next_digits){
        if (next_digits.length() == 0){
            result.add(combination);
        } else {
            String digit = next_digits.substring(0,1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++){
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

}
