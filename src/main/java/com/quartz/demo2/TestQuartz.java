package com.quartz.demo2;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
  
import java.util.Date;

import com.quartz.demo1.MailJob;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
   
public class TestQuartz {
    public static void main(String[] args) throws Exception{
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
   
            Date startTime = DateBuilder.nextGivenSecondDate(null, 8);
  
            JobDetail job = newJob(MailJob.class).withIdentity("mailJob", "mailGroup").build();
  
            CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0/2 * * * * ?"))
                    .build();
  
            // schedule it to run!
            Date ft = scheduler.scheduleJob(job, trigger);
             
            System.out.println("使用的Cron表达式是："+trigger.getCronExpression());
//            System.out.printf("%s 这个任务会在 %s 准时开始运行，累计运行%d次，间隔时间是%d毫秒%n", job.getKey(), ft.toLocaleString(), trigger.getRepeatCount()+1, trigger.getRepeatInterval());
             
            scheduler.start();
               
            //等待200秒，让前面的任务都执行完了之后，再关闭调度器
            Thread.sleep(200000);
            scheduler.shutdown(true);
    }
}