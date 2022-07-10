package com.moon.demo.service.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {
     
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();
        
        name.add("icon");
        age.add(18);
        number.add(314);
 
        getData(name);
        getData(age);
        getData(number);
        
        List<Integer> list = new ArrayList<>();

        list.add(12);
        //这里直接添加会报错
//        list.add("a");
        Class<?> clazz = list.getClass();
        try {
			Method add = clazz.getDeclaredMethod("add", Object.class);
			//但是通过反射添加，是可以的
			add.invoke(list, "kl");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        System.out.println(list);
       
   }
 
   public static void getData(List<?> data) {
      System.out.println("data :" + data.get(0));
   }
}