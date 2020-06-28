package com.anhen.demo;

import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName TestString
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/6/12 14:04
 * @Version 1.0
 **/

public class TestString {

    public static void main(String[] args) throws Exception{
        String createTime = "Every day 1";
        createTime = createTime.substring(createTime.indexOf(" ")).trim();
        String a=createTime.substring(createTime.indexOf(" ")).trim();
        System.out.println(a);
        InetAddress address= InetAddress.getByName("www.baidu.com");
        System.out.println(address);
        System.out.println(Integer.valueOf("05"));
        String[] as = new String[]{"pie","list"};
        Arrays.sort(as, Collections.reverseOrder());
        Arrays.stream(as).forEach(x-> System.out.println(x));

        String[] groupByString = "org-alert".split("-");
        String groupBy = groupByString[0];
        if (groupByString.length == 2) {
            System.out.println("length = 2");
        }
        System.out.println(groupBy);
        System.out.println(URLEncoder.encode("this is a test", "UTF-8").replace("+","%20"));
    }
}
