package com.moon.demo.service.designPattern.template.example2;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author wuxiaojian
 */
@Slf4j
public abstract class ServiceTemplate<T, R> {

    public R process(T request) {
    	log.info("start invoke: request=" + request);
        Stopwatch stopwatch = Stopwatch.createStarted();

        try {
            validParam(request);
            R response = doProcess(request);
            long timeCost = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            log.info("end invoke, response =" + response + ", costTime = " + timeCost);
            return response;
        } catch (Exception e) {
            log.error("error invoke, exception:" , e);
            return null;
        }
    }
    
    protected abstract void validParam(T request);
    
    protected abstract R doProcess(T request);

}