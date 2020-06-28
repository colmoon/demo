package com.goldcard.others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName pattern
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/15 15:33
 */
public class pattern {
    private static Pattern pattern = Pattern.compile("4641(.*?)46");

    public static void main(String[] args) {
        String data = "46412018111546";
        Matcher matcher = pattern.matcher(data);
        String group0 = null;
        String group1 = null;
        if(matcher.find()){
            group0 = matcher.group(0);
            group1 = matcher.group(1);
            System.out.println(group0);
            System.out.println(group1);
        }else{
            System.out.println("not match");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("80").append(data);
            data = stringBuffer.toString();
            System.out.println(data);
            return;
        }

    }

}
