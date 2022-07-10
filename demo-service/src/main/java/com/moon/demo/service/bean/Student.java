package com.moon.demo.service.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @classname: Student
 * @description: Student
 * @author: wuxiaojian
 * @create: 2020-05-09 11:03
 */
@Component
@Data
public class Student {
    private int age;
    private String name;

    @PostConstruct
    public void postConstruct(){
        System.out.println("【Student】 【@PostConstruct】 注解");
        this.age = 20;
        this.name = "test";
    }
}

