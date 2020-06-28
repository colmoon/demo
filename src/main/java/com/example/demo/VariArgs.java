package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VariArgs {
    private static final Logger LOG = LoggerFactory.getLogger(VariArgs.class);

    public static void main(String[] args) {  
        test();  
        test("aaa");  
        test("aaa", "bbb");  
        test("aaa", "bbb", "ccc");
        String[] strings = new String[]{"aaa", "bbb", "ccc", "ddd"};
        test(strings);
//        List<String> lists = Arrays.asList("aaa", "bbb", "ccc", "ddd");
//        test(lists);
        StringBuilder[] descriptions = new StringBuilder[10];
/*        for (int i = 0; i < 10; i++){
            descriptions[i] = new StringBuilder();
        }*/
        try {
            descriptions[0].append("e");
            String str = descriptions[0].toString();
        } catch (Exception e){
            LOG.error("异常",e);
        }

        System.out.println("r");

        int index = 1;
        int i = 0;
        String description = "#{" + index + (i+1) + "description}";
        System.out.println(description);

        DecimalFormat df = new DecimalFormat("#.00");
        double f = 11.6;
        float fd = 11.2f;
        String str = String.format("%.2f", f);
        System.out.println(str);

        Map<String, String> map = new HashMap<>();
        map.put("1", "apple");
        System.out.println(map);

    }  
  
    public static void test(String... args) {  
        System.out.println(args.getClass());  
        for (String arg : args) {  
            System.out.println(arg);  
        }  
    }  
}  