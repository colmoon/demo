package com.goldcard.lru;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @ClassName TreeMapConsistentHash
 * @Description
 * @Author wuxiaojian
 * @Date 2019/7/19 17:08
 * @Version 1.0
 **/

public class TreeMapConsistentHash extends AbstractConsistentHash {
    private TreeMap<Long,String> treeMap = new TreeMap<>() ;

    /**
     * 虚拟节点数量
     */
    private static final int VIRTUAL_NODE_SIZE = 2 ;

    @Override
    public void add(long key, String value) {
        for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
            Long hash = super.hash("vir" + key + i);
            treeMap.put(hash,value);
        }
        treeMap.put(key, value);
    }

    @Override
    public String getFirstNodeValue(String value) {
        long hash = super.hash(value);
        System.out.println("value=" + value + " hash = " + hash);
        SortedMap<Long, String> last = treeMap.tailMap(hash);
        if (!last.isEmpty()) {
            return last.get(last.firstKey());
        }
        return treeMap.firstEntry().getValue();
    }

    public static void main(String[] args) {
        TreeMapConsistentHash treeMapConsistentHash = new TreeMapConsistentHash();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            list.add("127.0.0." + i);
        }

        String process = treeMapConsistentHash.process(list, "zhangsan");

        System.out.println(process);
    }
}
