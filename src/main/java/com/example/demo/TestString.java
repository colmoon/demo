package com.example.demo;

/**
 * @ClassName TestString
 * @Description 字符串带有双引号则会放入到常量池（元空间）中
 * @Author wuxiaojian
 * @Date 2019/8/22 9:11
 * @Version 1.0
 **/

public class TestString {
    public static void main(String[] args) {
        String a = "hello";
        String b = new String("hello");
        System.out.println(a == b);//false

        String c = "world";
        System.out.println(c.intern() == c);//true

        String d = new String("mike");
        System.out.println(d.intern() == d);//false

        String e = new String("jo") + new String("hn");
        System.out.println(e.intern() == e);//true

        String f = new String("ja") + new String("va");
        System.out.println(f.intern() == f);//false 因为java启动时已经把java加入到常量池中了 intern就从常量池中获取

        String g = "asd" + "fgh";
        System.out.println(g.intern() == g);//true //asdfgh,没有在常量池中
    }
}
