package com.goldcard.lru;


import lombok.Data;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author wuxiaojian
 * @Description
 * 实现一个 LRU 缓存，当缓存数据达到 N 之后需要淘汰掉最近没有使用的数据。
 * N 小时之内没有被访问的数据也需要淘汰掉。
 * @Date 2019/7/19 14:42
 * @Param
 * @return
 **/
public class LRULinkedMap<K, V> {
    /**
     * 最大缓存大小
     */
    private int cacheSize;
    private LinkedHashMap<K, V> cacheMap;

    /**
     * 超时时间
     */
    private final static Long EXPIRE_TIME = 60 * 60 * 1000L ;

    /**
     * 检查是否超期线程
     */
    private ScheduledThreadPoolExecutor checkTimePool;

    private LinkedList<Node> linkedList = new LinkedList<>();

    public LRULinkedMap(int cacheSize) {
        this.cacheSize = cacheSize;
        cacheMap = new LinkedHashMap<K, V>(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return  (cacheSize + 1 == cacheMap.size());
            }
        };
        checkTimePool = new ScheduledThreadPoolExecutor(1);
        checkTimePool.scheduleAtFixedRate(new CheckTimeThread(), 0, 1, TimeUnit.SECONDS);
    }

    public void put(K key, V value) {
        cacheMap.put(key, value);
        linkedList.add(new Node(key,value));
    }

    public V get(K key) {
        return cacheMap.get(key);
    }

    public Collection<Map.Entry<K, V>> getAll() {
        return new ArrayList<Map.Entry<K, V>>(cacheMap.entrySet());
    }

    public static void main(String[] args) {
        LRULinkedMap<String,Integer> map = new LRULinkedMap<>(4) ;
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        for (Map.Entry<String, Integer> e : map.getAll()){
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
        System.out.println("");
        map.get("1") ;
        for (Map.Entry<String, Integer> e : map.getAll()){
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
    }

    @Data
    private class Node<K, V>{
        private K key;
        private V value;
        private Long updateTime;
        public Node(K k, V v){
            this.key = k;
            this.value = v;
            this.updateTime = System.currentTimeMillis();
        }
    }

    private class CheckTimeThread implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("CheckTimeThread");
                Iterator<Node> iterator = linkedList.iterator();
                while (iterator.hasNext()){
                    Node node = iterator.next();
                    Long updateTime = node.getUpdateTime() ;
                    if (updateTime == null){
                        continue;
                    }
                    if ((System.currentTimeMillis() - updateTime) >= EXPIRE_TIME){
                        iterator.remove();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}