package com.jdk8.Date;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName TestDate
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/16 11:18
 * @Version 1.0
 **/

public class TestDate {
    public static void main(String[] args) {
        //参考博客
        //https://www.cnblogs.com/comeboo/p/5378922.html

        // 获取当前时间
        Instant now = Instant.now();

        // T代表东西经0°经线区时：伦敦时间
        System.out.println(now);// 2017-11-25T14:06:57.079Z

        LocalDateTime localDateTime = LocalDateTime.parse("2019-04-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println(localDateTime);

        System.out.println("-----------------------------------");

        // 当前时间
        LocalDate now1 = LocalDate.now();
        System.out.println(now1.toString());

        // 往前推两天
        LocalDate date = now1.minusDays(2);
        System.out.println(date);

        // 制定一个日期
        LocalDate localDate = LocalDate.of(1993, 2, 6);
        System.out.println(localDate);


        System.out.println("-----------------------------------");

        // 当前时间
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);

        // 当前时间加上25小时３分钟
        LocalDateTime plusMinutes = now2.plusHours(25).plusMinutes(3);
        System.out.println(plusMinutes);

        // 转换
        LocalDateTime of = LocalDateTime.of(1993, 2, 6, 11, 23, 30);

        System.out.println("-----------------------------------");

        // 当前时间
        ZonedDateTime now3 = ZonedDateTime.now();
        System.out.println(now);

        // 创建时区的日期时间对象
        ZonedDateTime of3 = ZonedDateTime.of(LocalDateTime.of(1993, 2, 6, 11, 23, 30), ZoneId.of("+08"));
        System.out.println(of);

        System.out.println("-----------------------------------");

        // 格式化
        String time = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println(time);

        // 格式化
        LocalDateTime parse = LocalDateTime.parse("2017.01.01 08:08:08", DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        System.out.println(parse);

        System.out.println("-----------------------------------");
        LocalDate now5 = LocalDate.now();
        LocalDate future = LocalDate.of(2019, Month.AUGUST,15);
        Period period = Period.between(now5, future);
        System.out.printf("日期%s和日期%s相差%s月",now5,future,period.getMonths());
        int year = now5.getYear();
        int month = now5.getMonthValue();
        int day = now5.getDayOfMonth();
        System.out.printf("\n%s年%s月%s日\n",year,month,day);
        boolean isSameDay = now5.equals(future);
        LocalDate nextWeek = now5.plusWeeks(1);
        System.out.println(nextWeek);
        Clock clock = Clock.systemUTC();
        System.out.println(clock);
        System.out.println(future.isAfter(now5));
    }
}
