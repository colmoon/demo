package com.moon.demo.service.designPattern.observer.example3;

/**
 * @author wuxiaojian
 * 观察者接口
 */
public interface TransferObserver {

    /**
     * 回调接口
     **/
    void update(TransferResult transferResult);
}
