package com.moon.demo.service.designPattern.chain.example4;

import com.google.common.collect.Lists;
import com.moon.demo.service.designPattern.observer.example3.TransferObserver;
import com.moon.demo.service.designPattern.observer.example3.TransferResult;
import io.swagger.v3.oas.models.media.XML;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
public class ValidatorManager implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    private List<ParamValidator> paramValidatorList = Lists.newArrayList();


    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, ParamValidator> beansOfType = applicationContext.getBeansOfType(ParamValidator.class);
        paramValidatorList = new ArrayList<>(beansOfType.values());

    }

    /**
     * 通知观察者
     * @param transferResult:
     * @return: void
     **/
    public void checkParam(TransferResult transferResult) {
        paramValidatorList.forEach(x -> x.checkParam(transferResult));
    }
}
