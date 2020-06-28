package com.goldcard.file;

import java.io.File;
import java.io.FileOutputStream;

public class TestStream {
 
    /**
     * @param file 查找的目录
     * @param search 查找的字符串
     */
    public static void search(File file) {
        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
            	appendFileConent(file);
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f);
            }
        }
    }
    
    public static void appendFileConent(File file){
        try {
        	FileOutputStream fos = new FileOutputStream (file,true ) ;   
        	String str = "\n" ; //字符串末尾需要换行符
        	fos.write(str.getBytes()) ;   
        	fos.close ();   
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
 
    }
 
    public static void main(String[] args) {
        File folder =new File("e:\\project");
        search(folder);
    }
}