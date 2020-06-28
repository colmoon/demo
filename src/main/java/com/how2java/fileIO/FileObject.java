package com.how2java.fileIO;

import java.io.File;

/**
 * @ClassName FileObject
 * @Description
 * 一般说来操作系统都会安装在C盘，所以会有一个 C:\WINDOWS目录。
 *
 * 遍历这个目录下所有的文件(不用遍历子目录)
 *
 * 找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名
 * @Author wuxiaojian
 * @Date 2019/4/29 9:22
 * @Version 1.0
 **/

public class FileObject {

    private static File file = new File("E:\\workspace");
    private static long maxLength = 0;
    private static long minLength = Integer.MAX_VALUE;
    private static File maxFile = null, minFile = null;
    public static void main(String[] args) {
//        traversalFile(file);
        traversalFileRecursion(file);
        System.out.printf("max file is %s, length is %d \n",maxFile.getAbsoluteFile(),maxLength);
        System.out.printf("min file is %s, length is %d",minFile.getAbsoluteFile(),minLength);
    }

    //不遍历子目录
    public static void traversalFile(File file){
        File[] files = file.listFiles();
        if (files == null){
            return;
        }
        for (File subFile: files){
            if (subFile.isFile()){
                if (subFile.length() > maxLength){
                    maxLength = subFile.length();
                    maxFile = subFile;
                }
                if (subFile.length() < minLength){
                    minLength = subFile.length();
                    minFile = subFile;
                }
            }
        }

    }

    //遍历子目录
    private static void traversalFileRecursion(File file){
        File[] files = file.listFiles();
        if (files == null){
            return;
        }
        for (File subFile: files){
            if (subFile.isFile()){
                if (subFile.length() > maxLength){
                    maxLength = subFile.length();
                    maxFile = subFile;
                }
                if (subFile.length() < minLength){
                    minLength = subFile.length();
                    minFile = subFile;
                }
            } else if (subFile.isDirectory()){
                traversalFileRecursion(subFile);
            }
        }
    }

}
