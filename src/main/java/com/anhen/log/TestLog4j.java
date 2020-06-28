package com.anhen.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class TestLog4j {
//private static Logger log = LoggerFactory.getLogger(TestLog4j.class);
    @PostConstruct
    public void logTest(){
        log.info("************************************************");
        log.trace("跟踪信息");
        log.debug("调试信息");
        log.info("输出信息");
        log.warn("警告信息");
        log.error("错误信息");
        log.info("************************************************");
    }
}