package com.quartz.demo5;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TaskDemo
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/29 19:42
 * @Version 1.0
 **/
@Slf4j
@Component
public class TaskDemo implements Job{

    @DisallowConcurrentExecution
    public static class Demo1 implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            for (int i = 0; i < 1; i++) {
                log.info(i+" run ################## " + (new Date()));
            }
            try{
                TimeUnit.MINUTES.sleep(10);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        void print2(){
            System.out.println("i am inner class");
        }
    }

    @Component
    public static class Demo2 implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            for (int i = 0; i < 1; i++) {
                log.info(i+" run ***************** " + (new Date()));
            }
        }
        void print2(){
            System.out.println("i am inner class");
        }
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.quartz.demo5.TaskDemo$Demo1");
            System.out.println(clazz.getName());
            Method method2 = clazz.getDeclaredMethod("print2");
            //通过构造函数创建实例,如果没有重写构造方法则不管是不是获取已声明构造方法,结果是一样的
            method2.invoke(clazz.getDeclaredConstructors()[0].newInstance(clazz.newInstance()));
        } catch (Exception e){
            log.error("",e);
        }

    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        for (int i = 0; i < 2; i++) {
            log.info(i+" run ~~~~~~~~~~~~~~~~~ " + (new Date()));
        }
    }
}
