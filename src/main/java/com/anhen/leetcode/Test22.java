package com.anhen.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Test22
 * @Description
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * @Author wuxiaojian
 * @Date 2020/6/22 23:02
 * @Version 1.0
 **/

public class Test22 {
    public static void main(String[] args) {
        List<String> combinations = generateParenthesis5(3);
        System.out.println(combinations.toString());
    }

    //暴力法
    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    private static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    private static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }


    //回溯法
    private static List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    //深度优先遍历 减法
    private static List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList<>();
        dfs("", n ,n, ans);
        return ans;
    }

    private static void dfs(String cur, int left, int right, List<String> result){
        if (left == 0 && right == 0){
            result.add(cur);
            return;
        }
        //剪枝，当剩余的左括号大于右括号，无效
        if (left > right){
            return;
        }
        if (left > 0){
            dfs(cur + "(", left - 1, right, result);
        }
        if (right > 0){
            dfs(cur + ")", left, right - 1, result);
        }
    }

    //深度优先遍历 加法
    private static List<String> generateParenthesis4(int n) {
        List<String> ans = new ArrayList<>();
        dfs2("", 0, 0, ans, n);
        return ans;
    }


    //深度优先遍历 加法
    private static void dfs2(String cur, int left, int right, List<String> result, int n){
        if (left == n && right == n){
            result.add(cur);
            return;
        }
        //剪枝，当剩余的左括号大于右括号，无效
        if (left < right){
            return;
        }
        if (left < n){
            dfs2(cur + "(", left + 1, right, result, n);
        }
        if (right < n){
            dfs2(cur + ")", left, right + 1, result, n);
        }
    }

    public static class Node {
        //当前得到的字符串
        private String res;
        //当前剩余的左括号数量
        private int left;
        //当前剩余的右括号数量
        private int right;

        public Node(String res, int left, int right){
            this.res = res;
            this.left = left;
            this.right = right;
        }
    }

    //广度优先遍历 队列
    private static List<String> generateParenthesis5(int n) {
        List<String> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("", n, n));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.left == 0 && node.right == 0){
                ans.add(node.res);
            }
            if (node.left > node.right){
                continue;
            }
            if (node.left > 0){
                queue.add(new Node(node.res + "(", node.left - 1, node.right));
            }
            if (node.right > 0){
                queue.add(new Node(node.res + ")", node.left, node.right - 1));
            }
        }
        return ans;
    }


}
