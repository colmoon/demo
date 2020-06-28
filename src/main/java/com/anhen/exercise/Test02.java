package com.anhen.exercise;

/**
 * @ClassName Test02
 * @Description
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author wuxiaojian
 * @Date 2020/5/12 21:20
 * @Version 1.0
 **/

public class Test02 {
    public static void main(String[] args) {

    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null){
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                result.append('%');
                result.append('2');
                result.append('0');
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
