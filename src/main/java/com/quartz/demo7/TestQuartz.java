package com.quartz.demo7;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @classname: TestQuartz
 * @description: TestQuartz
 * https://www.cnblogs.com/pzy4447/p/5201674.html
 * @author: wuxiaojian
 * @create: 2020-07-10 11:17
 */
public class TestQuartz {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        //Job #1 is scheduled to run every 3 seconds indefinitely. An execution delay of 10 seconds is passed into the job:

        JobDetail job = newJob(StatefulDumbJob.class)
                .withIdentity("statefulJob1", "group1")
                .usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L)
                .build();

        SimpleTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3)
                        .repeatForever())
                .build();

        sched.scheduleJob(job, trigger);
        //Job #2 is scheduled to run every 3 seconds indefinitely. An execution delay of 10 seconds is passed into the job:

        job = newJob(StatefulDumbJob.class)
                .withIdentity("statefulJob2", "group1")
                .usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L)
                .build();

        trigger = newTrigger()
                .withIdentity("trigger2", "group1")
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3)
                        .repeatForever()
                        .withMisfireHandlingInstructionNowWithExistingCount()) // set misfire instruction
                .build();

        sched.scheduleJob(job, trigger);

        sched.start();

        Thread.sleep(600L * 1000L);

        sched.shutdown(true);
    }
}
