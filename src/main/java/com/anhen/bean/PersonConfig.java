package com.anhen.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @classname: PersonConfig
 * @description: PersonConfig
 * @author: wuxiaojian
 * @create: 2020-05-09 10:23
 */
@Slf4j
@Configuration
public class PersonConfig {

    @Bean(initMethod = "myInit", destroyMethod = "myDestroy")
    public Person person(){
        log.info(">>>>>>>>>>> person config init.");
        Person person = new Person();
        person.setAddress("杭州");
        person.setName("tom");
        person.setPhone(123);
        return person;
    }

    /*@Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        log.info(">>>>>>>>>>> myBeanPostProcessor config init.");
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyInstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor(){
        log.info(">>>>>>>>>>> myInstantiationAwareBeanPostProcessor config init.");
        return new MyInstantiationAwareBeanPostProcessor();
    }*/
}
