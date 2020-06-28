package com.goldcard.others;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateTest
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/15 21:44
 */

public class DateTest {

    public static void main(String[] args) {
        System.out.println("printlnDate方法开始打印 ==》》");
        printlnDate();
        System.out.println("testSet方法开始打印 ==》》");
        testSet();
        System.out.println("afterDays方法开始打印 ==》》");
        afterDays(new Date(), 8);
    }

    /**
     * 测试一些参数的作用
     */
    public static void printlnDate() {
        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        // 月份是从0开始的所以要加1
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        int secend = cal.get(Calendar.SECOND);

        System.out.println("当期时间: " + cal.getTime());
        System.out.println("年份: " + year);
        System.out.println("月份: " + month);
        System.out.println("日  : " + day);
        System.out.println("秒  ：" + secend);

        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);
        int woy = cal.get(Calendar.WEEK_OF_YEAR);

        // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
        System.out.println("一周的第几天: " + dow);
        System.out.println("一月中的第几天: " + dom);
        System.out.println("一年的第几天: " + doy);
        System.out.println("一年中的第几周 " + woy);
    }

    /**
     * 获取date之后多少天的日期
     *
     * @param date
     * @param after
     * @return
     */
    public static void afterDays(Date date, Integer after) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, after);
        System.out.println("之前的日期为：" + date);
        System.out.println(after + "天之后的日期为：" + cal.getTime());
    }

    /**
     * set方法
     */
    public static void testSet() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        System.out.println("之前的日期：" + cal.getTime());
        cal.set(Calendar.DAY_OF_MONTH, 23);
        System.out.println("set之后的日期：" + cal.getTime());
    }
}
