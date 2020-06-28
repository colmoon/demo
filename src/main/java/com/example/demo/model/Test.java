package com.example.demo.model;

import com.alibaba.fastjson.JSON;

import java.util.Calendar;

/**
 * @ClassName Test
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/28 9:23
 * @Version 1.0
 **/

public class Test {
    public static void main(String[] args) {
        testCalendar();
    }

    public static void testCalendar() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);

        System.out.println("当期时间: " + cal.getTime());
        System.out.println("日期: " + day);
        System.out.println("月份: " + month);
        System.out.println("年份: " + year);
        System.out.println("一周的第几天: " + dow);  // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
        System.out.println("一月中的第几天: " + dom);
        System.out.println("一年的第几天: " + doy);
    }

    public static void testJson(){
        Room room = new Room();
        room.setLocation("China");
        room.setId(1);
        room.setName("computer");
        room.setProjectId(2);
        CheckAsset checkAsset = room;
        System.out.println(JSON.toJSONString(checkAsset));
        System.out.println(JSON.toJSONString(room));
    }
}
