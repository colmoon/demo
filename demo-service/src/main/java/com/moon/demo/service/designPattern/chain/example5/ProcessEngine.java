package com.moon.demo.service.designPattern.chain.example5;

/**
 * @classname: ProcessEngine
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2024-01-04 18:59
 */
public interface ProcessEngine {

    /**
     * 启动流程引擎
     * @param request:
     * @param context:
     * @return: void
     **/
    void start(ProcessRequest request, ProcessContext context);
}
