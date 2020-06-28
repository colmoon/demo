package com.quartz.demo5;

import com.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName QuartzJobFactory
 * @Description QuartzJobFactory
 * @Author wuxiaojian
 * @Date 2019/5/31 9:47
 * @Version 1.0
 **/

//解决Job中注入Spring Bean为null的问题
/**
 * 创建job 实例工厂，解决spring注入问题，如果使用默认会导致spring的@Autowired 无法注入问题
 * @author LLQ
 *
 */
@Component
@Slf4j
public class QuartzJobFactory extends AdaptableJobFactory{
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = null;
        try {
            jobInstance = SpringUtil.getBean(bundle.getJobDetail().getJobClass());
        } catch (Exception e){
            //静态内部类容器是获取不到的，会报错
            log.error(e.getMessage());
        }
        if (jobInstance == null) {
            //调用父类的方法
            jobInstance = super.createJobInstance(bundle);
            //进行注入
            capableBeanFactory.autowireBean(jobInstance);
        }
        return jobInstance;
    }

}