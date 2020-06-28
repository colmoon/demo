package com.quartz.demo5;

import com.quartz.demo5.service.Task3;
import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;

/**
 * @Author by xup .
 * @Descriptions
 * @Datetime in 2018/1/30 17:07.
 */
@Configuration
public class QuartzConfiguration {
    @Autowired
    QuartzJobFactory quartzJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws Exception {

        SchedulerFactoryBean factoryBean=new SchedulerFactoryBean();
        factoryBean.setJobFactory(quartzJobFactory);
//        factoryBean.afterPropertiesSet();
        factoryBean.setStartupDelay(1);
        factoryBean.setQuartzProperties(quartzProperties());
//        Scheduler scheduler=factoryBean.getScheduler();
//        scheduler.start();
        return factoryBean;
    }


    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean(name="scheduler")
    public Scheduler scheduler() throws Exception {
        return schedulerFactoryBean().getScheduler();
    }


//    @Bean
    //不需要随web 启动就启动 schedule
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }


    //注入scheduler到spring，在下面quartzManage会用到
    @Bean
    public Properties quartzProperties() throws IOException {
        //使用Spring的PropertiesFactoryBean对属性配置文件进行管理
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();

        Properties properties = propertiesFactoryBean.getObject();

        // 账号密码
        String user = properties.getProperty("org.quartz.dataSource.qzDS.user");
        if (user != null) {
            properties.setProperty("org.quartz.dataSource.qzDS.user", user);
        }
        String password = properties.getProperty("org.quartz.dataSource.qzDS.password");
        if (password != null) {
            properties.setProperty("org.quartz.dataSource.qzDS.password", password);
        }

        return properties;
    }
}