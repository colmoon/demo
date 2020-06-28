package com.anhen.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName TestReadRule
 * @Description 测试读取规则文件
 * @Author wuxiaojian
 * @Date 2019/9/2 15:16
 * @Version 1.0
 **/

public class TestReadRule {
    public static void main(String[] args) {
        String path = "E:\\rules";
        File fileRules = new File(path);
        File[] files = fileRules.listFiles();
        if (files == null || files.length == 0){
            return;
        }
        Arrays.stream(files).forEach(file -> {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    if (!line.trim().startsWith("#")){
                        System.out.println(line);
                        int first = line.indexOf("(");
                        int last = line.indexOf(")");
                        String content = line.substring(first+1,last);
                        System.out.println(content);
                        String[] strings = content.split(";");
                        HashMap<String,String> hashMap = new HashMap<>();
                        Arrays.stream(strings).forEach(s -> {
                            String[] strings1 = s.split(":");
                            hashMap.put(strings1[0].trim(),strings1[1].trim());
                        });
                        Rule rule = new Rule();
                        rule.setRuleName(hashMap.get("msg"));
                        rule.setRuleId(hashMap.get("sid"));
                        System.out.println(rule.toString());
                     }
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        });
    }
}
