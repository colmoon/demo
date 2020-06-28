package com.anhen.demo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @ClassName TestIP
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/6/11 18:50
 * @Version 1.0
 **/

public class TestIP {
    public static void main(String[] args) {
        String ipSegment = "192.168.11.103/24";
        String[] strings = ipSegment.split("/");
        String ip = strings[0];
        int segment = Integer.parseInt(strings[1]);
        //ip地址二进制形式
        String ipBinary = StringUtils.leftPad(Long.toBinaryString(ipToLong(ip)), 32, '0');
        //ip地址网络地址
        String ipNetwork = ipBinary.substring(0,segment);
        //此网段最小地址
        String ipStrStart = StringUtils.rightPad(ipNetwork,32,'0');
        //此网段最大地址
        String ipStrEnd = StringUtils.rightPad(ipNetwork,32,'1');
        long ipStart = Long.parseLong(StringUtils.leftPad(ipStrStart,64,'0'),2);
        long ipEnd = Long.parseLong(StringUtils.leftPad(ipStrEnd,64,'0'),2);
        System.out.println(ipStart + "    " + ipEnd);
        System.out.println(LocaleContextHolder.getLocale());
    }

    public static long ipToLong(String ipAddress) {

        long result = 0;

        String[] ipAddressInArray = ipAddress.split("\\.");

        for (int i = 3; i >= 0; i--) {

            long ip = Long.parseLong(ipAddressInArray[3 - i]);

            //left shifting 24,16,8,0 and bitwise OR

            //1. 192 << 24
            //1. 168 << 16
            //1. 1  << 8
            //1. 2  << 0
            result |= ip << (i * 8);

        }
        return result;
    }
}
