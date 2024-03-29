package com.moon.demo.algorithm.others;

import java.util.*;

/**
 * TreeMap实现了SortedMap接口，保证了有序性。默认的排序是根据key值进行升序排序，也可以重写comparator方法来根据value进行排序。
 */

public class SortedMapTest2 {
    public static void main(String[] args) {

        Map<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("1b", "a");
        hashMap.put("2", "b");
        hashMap.put("4b", "d");
        hashMap.put("3", "c");
        hashMap.put("2b", "d");
        hashMap.put("3b", "c");
        Set<Map.Entry<String, Object>> entry = hashMap.entrySet();
        for(Map.Entry<String, Object> temp : entry){
            System.out.println("hashMap:"+temp.getKey()+" 值"+temp.getValue());
        }

        System.out.println("\n");

        SortedMap<String,Object> sortedMap = new TreeMap<String,Object>();
        sortedMap.put("1b", "a");
        sortedMap.put("2", "b");
        sortedMap.put("4b", "d");
        sortedMap.put("3", "c");
        sortedMap.put("2b", "d");
        sortedMap.put("3b", "c");
        Set<Map.Entry<String, Object>> entry2 = sortedMap.entrySet();
        for(Map.Entry<String, Object> temp : entry2){
            System.out.println("sortedMap:"+temp.getKey()+" 值"+temp.getValue());
        }

    }

}
