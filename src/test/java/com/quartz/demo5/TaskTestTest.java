package com.quartz.demo5;

import com.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class TaskTestTest extends BaseTest {

    @Autowired
    QuartzManage quartzManage;

    @Test
    public void execute() {
        try{
            QuartzJob quartzJob = new QuartzJob();
            quartzJob.setBeanName("com.quartz.demo5.TaskTest");
            quartzJob.setJobName("mailJob");
            quartzJob.setCronExpression("0/2 * * * * ?");
            quartzJob.setTriggerName("trigger1");
            quartzJob.setDelay(30);
            quartzManage.addJob(quartzJob);
            Thread.sleep(100000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}