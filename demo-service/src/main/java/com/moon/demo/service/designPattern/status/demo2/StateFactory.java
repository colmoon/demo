package com.moon.demo.service.designPattern.status.demo2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName StateFactory
 * @Description 工厂类
 * @Author wuxiaojian
 * @Date 2019/7/19 11:00
 * @Version 1.0
 **/

public class StateFactory {
    private static Map<ApprovalState, State> statesInstance = new ConcurrentHashMap<>();

    static {
        put(ApprovalState.YES, new Yes());
        put(ApprovalState.NO, new No());
        put(ApprovalState.CANCEL, new Cancel());
    }

    public static void put(ApprovalState key, State value){
        statesInstance.put(key, value);
    }

    public static State get(ApprovalState key){
        return statesInstance.get(key);
    }
}
