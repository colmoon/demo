package com.anhen.controller.service;

import com.anhen.controller.model.SysLogBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysLogService {
 
    public boolean save(SysLogBO sysLogBO){
        // 这里就不做具体实现了
        // 插入到数据库中
        log.info(sysLogBO.getParams());
        return true;
    }
}