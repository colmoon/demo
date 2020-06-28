package com.example.demo;

import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.HashMap;

/**
 * @ClassName TestAbs
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2019/2/14 16:59
 */
public class TestAbs {

    public static void main(String[] args) {
        int key2 = Math.abs(Integer.MIN_VALUE);
        long key1 = Math.abs(Integer.MIN_VALUE);
        int key = 1 & Integer.MAX_VALUE;
        System.out.println(key);

        HashMap<String, String> hashMap = new HashMap<>();

        String dateStr = "2012-12-12 12:12:12";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);

        String riskLevel = "中";
        String riskLevels = "高中低";
        if (riskLevels.contains(riskLevel)){
            System.out.println(true);
        }

        System.out.println("测试创建合并分支");

        String str = "apple";
        String strBack = str;
        str = null;
        System.out.println(strBack);

        System.out.println(new Date());
    }
}
