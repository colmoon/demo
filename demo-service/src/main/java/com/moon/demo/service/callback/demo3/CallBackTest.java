package com.moon.demo.service.callback.demo3;

import com.moon.demo.service.model.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * @classname: CallBackTest
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2024-01-16 08:43
 */
@Slf4j
public class CallBackTest {

    public static void main(String[] args) {
        ServiceA serviceA = new ServiceA();

        //同步调用
        try {
            serviceA.call();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        //异步调用
        serviceA.callAsync((response, throwable) -> {
            log.info(response.getMessage());
            if (Objects.nonNull(throwable)) {
                log.error(throwable.getMessage(), throwable);
            }
        });

        //java内置的异步调用
        CompletableFuture.supplyAsync(CallBackTest::doBiz)
                .whenComplete((response, throwable) -> {
                    log.info(response.getMessage());
                    if (Objects.nonNull(throwable)) {
                        log.error(throwable.getMessage(), throwable);
                    }
                });
    }

    public static Response doBiz() {
        ServiceA serviceA = new ServiceA();
        return serviceA.call();
    }

}
