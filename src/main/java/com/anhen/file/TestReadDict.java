package com.anhen.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @ClassName TestReadDict
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/30 10:14
 * @Version 1.0
 **/

public class TestReadDict {
    private static Logger logger = LoggerFactory.getLogger(TestReadDict.class);
    public static void main(String[] args) {
        try {
            logger.info("读取文件");
            File file = ResourceUtils.getFile("classpath:system/dictionary.json");
            // 向文件中写入文件
            File f = new File("d:/dictionary.data");
            try (
                    // 创建文件字符流
                    FileWriter fw = new FileWriter(f,true);
                    // 缓存流必须建立在一个存在的流的基础上
                    PrintWriter pw = new PrintWriter(fw);
            ){
                String fileString = FileUtils.readFileToString(file);
                int i = 4300;
                Map<String,Map<String,String>> mapMap = JSON.parseObject(fileString,new TypeReference<Map<String,Map<String,String>>>() {});
                for (Map.Entry<String,Map<String,String>> entry : mapMap.entrySet()) {
                    String key = entry.getKey();
                    for (Map.Entry<String, String> subEntry : entry.getValue().entrySet()) {
                        Dictionary dictionary = new Dictionary();
                        dictionary.setId(String.valueOf(i++));
                        dictionary.setCategory(key);
                        dictionary.setKey(subEntry.getKey());
                        dictionary.setName(subEntry.getValue());
                        pw.println(JSON.toJSONString(dictionary));
                    }
                    i = i + 20;
                }
            }


        } catch (Exception e){
            logger.info(e.getMessage());
        }
    }

    @Data
    @JSONType(orders={"id","category","key","name"})
    private static class Dictionary{
        String id;
        String category;
        String key;
        String name;
    }
}
