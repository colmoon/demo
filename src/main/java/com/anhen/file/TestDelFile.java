package com.anhen.file;


import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @ClassName TestDelFile
 * @Description 删除文件
 * @Author wuxiaojian
 * @Date 2019/8/15 13:33
 * @Version 1.0
 **/

public class TestDelFile {

    public static void main(String[] args) {
        String filePath = "E:\\anhen\\data";
        if(!Files.exists(Paths.get(filePath))){
            System.out.println("path is not exist, create path : " + filePath);
            try {
                Files.createDirectories(Paths.get(filePath));
                String content = "Hello";
                String target = filePath + File.separator + "hello.txt";
                Files.write(Paths.get(target), content.getBytes());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        //文件IO流需要关闭
        try(Stream<Path> stream = Files.list(Paths.get(filePath))) {
            stream.forEach(path -> {
                try {
                    Files.delete(path);
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            });
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        FileUtil.del(filePath);
    }

}
