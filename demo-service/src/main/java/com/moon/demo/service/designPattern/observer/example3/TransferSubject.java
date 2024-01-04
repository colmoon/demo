package com.moon.demo.service.designPattern.observer.example3;

import com.google.common.collect.Lists;
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
public class TransferSubject implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    private final List<TransferObserver> transferObserverList = Lists.newArrayList();

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public void afterPropertiesSet() throws Exception {

        Map<String, TransferObserver> beansOfType = applicationContext.getBeansOfType(TransferObserver.class);
        beansOfType.values().forEach(this::addObserver);

    }

    /**
     * 通知观察者
     * @param transferResult:
     * @return: void
     **/
    public void notifyObserver(TransferResult transferResult) {
        transferObserverList.forEach(transferObserver -> {
            executorService.execute(() -> transferObserver.update(transferResult));
        });
    }

    /**
     * 添加观察者
     * @param transferObserver:
     * @return: void
     **/
    public void addObserver(TransferObserver transferObserver) {
        transferObserverList.add(transferObserver);
    }
}
