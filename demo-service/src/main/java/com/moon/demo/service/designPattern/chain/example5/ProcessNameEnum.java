package com.moon.demo.service.designPattern.chain.example5;

import lombok.Getter;

/**
 * @author wuxiaojian
 */

public enum ProcessNameEnum {

    CONSUME("consumeRecordProcessor","消费者执行器");

    @Getter
    private String key;
    @Getter
    private String value;

    ProcessNameEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
