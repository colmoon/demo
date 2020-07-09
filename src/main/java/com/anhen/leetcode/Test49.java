package com.anhen.leetcode;

import java.util.*;

/**
 * @classname: Test49
 * @description:
 *
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 *
 * @author: wuxiaojian
 * @create: 2020-07-09 18:28
 */
public class Test49 {

    public static void main(String[] args) {
        Test49 test49 = new Test49();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = test49.groupAnagrams(strs);
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(Arrays.toString(chars),k->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }


    /**
     * 方法二：按计数分类
     * 思路
     *
     * 当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
     *
     * 算法
     *
     * 我们可以将每个字符串 \text{s}s 转换为字符数 \text{count}count，由26个非负整数组成，表示 \text{a}a，\text{b}b，\text{c}c 的数量等。我们使用这些计数作为哈希映射的基础。
     *
     * 在 Java 中，我们的字符数 count 的散列化表示将是一个用 **＃** 字符分隔的字符串。 例如，abbccc 将表示为 ＃1＃2＃3＃0＃0＃0 ...＃0，其中总共有26个条目。 在 python 中，表示将是一个计数的元组。 例如，abbccc 将表示为 (1,2,3,0,0，...，0)，其中总共有 26 个条目。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param strs: strs
     * @return: java.util.List<java.util.List<java.lang.String>>
     **/
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<String>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}
