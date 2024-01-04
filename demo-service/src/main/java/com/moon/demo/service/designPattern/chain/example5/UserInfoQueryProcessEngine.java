package com.moon.demo.service.designPattern.chain.example5;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: UserInfoQueryProcessEngine
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2024-01-04 19:11
 */
@Component
public class UserInfoQueryProcessEngine extends  AbstractProcessEngineImpl {

    private static final List<ProcessNameEnum> PROCESSOR_LIST = new ArrayList<>();

    static {
        PROCESSOR_LIST.add(ProcessNameEnum.CONSUME);
    }

    @Override
    protected List<ProcessNameEnum> getProcessors() {
        return PROCESSOR_LIST;
    }
}
