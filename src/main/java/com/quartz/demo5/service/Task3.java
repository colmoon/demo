package com.quartz.demo5.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName Task3
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/31 10:26
 * @Version 1.0
 **/
@Slf4j
@Component
public class Task3 {
    public void run() {
        for (int i = 0; i < 2; i++) {
            log.info(i+" run ################## " + (new Date()));
        }
    }
}

