package com.moon.demo.service.callback.demo3;

/**
 * @classname: CallBack
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2024-01-16 08:38
 */
public interface CallBack<T> {

    /**
     * 回调接口
     * @param result:
     * @param e:
     * @return: void
     **/
    void handle(T result, Throwable e);

}
