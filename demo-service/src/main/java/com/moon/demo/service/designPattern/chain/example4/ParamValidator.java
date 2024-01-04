package com.moon.demo.service.designPattern.chain.example4;

import com.moon.demo.service.designPattern.observer.example3.TransferResult;

/**
 * @author wuxiaojian
 * 参数校验器接口
 */
public interface ParamValidator {

    void checkParam(TransferResult transferResult);
}
