package com.anhen.common;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Executors
 * @Description 单例模式线程池
 * @Author wuxiaojian
 * @Date 2019/8/16 9:47
 * @Version 1.0
 **/

public class Executors {
    private static Logger logger = LoggerFactory.getLogger(Executors.class);


    private Executors(){

    }

    private static class SingleHolder{
        private static ExecutorService THREAD_POOL = new ThreadPoolExecutor(
                5,5,
                0L,TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(32),
                new BasicThreadFactory.Builder().namingPattern("File thread %s").build(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    public static ExecutorService getInstance(){
        return SingleHolder.THREAD_POOL;
    }

    public static void main(String[] args) {
        Executors.getInstance().submit(()->{
            try {
                System.out.println("thread do something");
                logger.info("thread do something");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
    }
}
