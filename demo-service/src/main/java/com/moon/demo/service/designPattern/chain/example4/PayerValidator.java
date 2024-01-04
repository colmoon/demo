package com.moon.demo.service.designPattern.chain.example4;

import com.moon.demo.service.designPattern.observer.example3.TransferResult;
import org.springframework.stereotype.Component;

/**
 * @classname: PayerValidator
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2024-01-04 18:33
 */
@Component
public class PayerValidator implements ParamValidator{
    @Override
    public void checkParam(TransferResult transferResult) {
        //执行校验方法
    }
}
