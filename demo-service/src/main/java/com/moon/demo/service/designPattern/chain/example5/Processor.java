package com.moon.demo.service.designPattern.chain.example5;

/**
 * @classname: Processor
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2024-01-04 18:55
 */
public interface Processor {

    /**
     * 是否需要执行此处理器
     * @param request:
     * @param context:
     * @return: boolean
     **/
    boolean needExecute(ProcessRequest request, ProcessContext context);

    /**
     * 执行处理器
     * @param request:
     * @param context:
     * @return: void
     **/
    void execute(ProcessRequest request, ProcessContext context);
}
