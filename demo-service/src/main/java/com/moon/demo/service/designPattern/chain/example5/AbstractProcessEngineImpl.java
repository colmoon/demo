package com.moon.demo.service.designPattern.chain.example5;

import com.google.common.collect.Lists;
import com.moon.demo.service.designPattern.observer.example3.TransferObserver;
import com.moon.demo.service.designPattern.observer.example3.TransferResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @classname: TransferSubject
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2024-01-04 18:15
 */
@Component
@Slf4j
public abstract class AbstractProcessEngineImpl implements ProcessEngine {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void start(ProcessRequest request, ProcessContext context) {
        //获取执行器列表
        List<ProcessNameEnum> processors = this.getProcessors();

        try {
            //逐个运行执行器
            processors.forEach(processName -> {
                Object bean = applicationContext.getBean(processName.getKey());
                if (!(bean instanceof Processor)) {
                    log.error("");
                    return;
                }
                Processor processor = (Processor) bean;
                if (!processor.needExecute(request, context)) {
                    return;
                }
                processor.execute(request,context);
            });
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    protected abstract List<ProcessNameEnum> getProcessors();
}
