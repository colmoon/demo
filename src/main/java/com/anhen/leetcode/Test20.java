package com.anhen.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName Test20
 * @Description
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author wuxiaojian
 * @Date 2020/6/17 22:57
 * @Version 1.0
 **/

public class Test20 {
    public static void main(String[] args) {
        System.out.println(isValid("([]){}"));
    }

    private static Map<Character, Character> map = new HashMap<Character, Character>(){{
        put(')','(');
        put(']','[');
        put('}','{');
    }};

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            } else {
                Character character = stack.isEmpty() ? '#' : stack.pop();
                if (!(character == map.get(s.charAt(i)))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
