package com.quartz.demo5;

import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static com.quartz.demo5.QuartzJob.*;

/**
 * @Author wuxiaojian
 * @Description 定时任务管理
 * @Date  2019/6/13 9:50
 * @Param
 * @return
 **/
@Component
public class QuartzManage {

    @Resource(name = "scheduler")
    private Scheduler scheduler;

    public void addJob(QuartzJob job) throws SchedulerException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //通过类名获取实体类，即要执行的定时任务的类
        Class<?> clazz = Class.forName(job.getBeanName());
        Job jobEntity = (Job)clazz.newInstance();
        //通过实体类和任务名创建 JobDetail
        JobDetail jobDetail = newJob(jobEntity.getClass())
                .withIdentity(job.getJobName()).build();

        Optional<Integer> jobDelay = Optional.ofNullable(job.getDelay());
        Date startTime = DateBuilder.futureDate(jobDelay.orElse(0), DateBuilder.IntervalUnit.SECOND);
        Trigger trigger;
        if (CRON_TRIGGER.equals(job.getTriggerType()) && StringUtils.isNotEmpty(job.getCronExpression())){
            //通过触发器名和cron 表达式创建 Trigger
            trigger = newTrigger()
                    .withIdentity(job.getTriggerName())
                    .startAt(startTime)
                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression()))
                    .build();
        } else if (SIMPLE_TRIGGER.equals(job.getTriggerType()) && job.getSimpleTriggerInterval() > 0){
            //有重复次数
            if (job.getSimpleTriggerCount() > 0){
                trigger = newTrigger()
                        .withIdentity(job.getTriggerName())
                        .startAt(startTime)
                        .withSchedule(simpleSchedule()
                                .withRepeatCount(job.getSimpleTriggerCount() - 1)
                                .withIntervalInSeconds(job.getSimpleTriggerInterval()))
                        .build();
            } else {
                //无限重复
                trigger = newTrigger()
                        .withIdentity(job.getTriggerName())
                        .startAt(startTime)
                        .withSchedule(simpleSchedule()
                                .repeatForever()
                                .withIntervalInSeconds(job.getSimpleTriggerInterval()))
                        .build();
            }
        } else {
            throw new IllegalArgumentException();
        }
        //执行定时任务
        scheduler.scheduleJob(jobDetail,trigger);
    }

    /**
     * 更新job cron表达式
     * @param quartzJob
     * @throws SchedulerException
     */
    public void updateJobCron(QuartzJob quartzJob) throws SchedulerException {

        TriggerKey triggerKey = TriggerKey.triggerKey(quartzJob.getJobName());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzJob.getCronExpression());
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        scheduler.rescheduleJob(triggerKey, trigger);
    }
    /**
     * 删除一个job
     * @param quartzJob
     * @throws SchedulerException
     */
    public void deleteJob(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(quartzJob.getJobName());
        scheduler.deleteJob(jobKey);
    }
    /**
     * 恢复一个job
     * @param quartzJob
     * @throws SchedulerException
     */
    public void resumeJob(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(quartzJob.getJobName());
        scheduler.resumeJob(jobKey);
    }
    /**
     * 立即执行job
     * @param quartzJob
     * @throws SchedulerException
     */
    public void runAJobNow(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(quartzJob.getJobName());
        scheduler.triggerJob(jobKey);
    }
    /**
     * 暂停一个job
     * @param quartzJob
     * @throws SchedulerException
     */
    public void pauseJob(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(quartzJob.getJobName());
        scheduler.pauseJob(jobKey);
    }
}