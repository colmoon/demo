package com.anhen.file;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName TestRead
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/18 15:24
 * @Version 1.0
 **/

public class TestRead {
    private static Logger logger = LoggerFactory.getLogger(TestRead.class);

    public static void main(String[] args) {
        try {
            logger.info("读取文件");
            File file = ResourceUtils.getFile("classpath:system/historyEvent.json");
            System.out.println(file.isDirectory());
            String fileString = FileUtils.readFileToString(file);
//            List<HistoryEvent> list = JSONArray.parseArray(fileString,HistoryEvent.class);
            List<HistoryEvent> list = JSON.parseArray(fileString,HistoryEvent.class);
//            List<HistoryEvent> list = JSON.parseObject(fileString,new TypeReference<ArrayList<HistoryEvent>>() {});
            list.forEach(System.out::println);
            System.out.println("写入文件");
//            File fileWrite = ResourceUtils.getFile("classpath:system/historyEventWrite.json");
//            FileUtils.writeStringToFile(fileWrite,fileString);
            System.out.println(pathJoin("work","temp"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static String pathJoin(String... path){
        return String.join(File.separator,path);
    }

}
