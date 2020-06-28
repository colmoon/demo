package com.quartz.demo5;

import com.quartz.demo5.service.Task3;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class TaskTest implements Job {
	@Autowired
	Task3 task3;

	@Autowired
	TaskDemo.Demo2 demo2;

	public void run() {
	    for (int i = 0; i < 2; i++) {
    		log.info(i+" run ################## " + (new Date()));
    	    }
	}
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//		run();
//		task3.run();
		demo2.print2();
	}

}