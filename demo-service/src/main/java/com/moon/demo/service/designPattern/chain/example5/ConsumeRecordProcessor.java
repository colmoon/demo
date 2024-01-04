package com.moon.demo.service.designPattern.chain.example5;

import org.springframework.stereotype.Component;

/**
 * @classname: ConsumeRecordProcessor
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2024-01-04 18:58
 */
@Component
public class ConsumeRecordProcessor implements Processor {

    @Override
    public boolean needExecute(ProcessRequest request, ProcessContext context) {
        return false;
    }

    @Override
    public void execute(ProcessRequest request, ProcessContext context) {

    }
}
