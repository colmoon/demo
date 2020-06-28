package com.quartz.demo5.service.impl;

import com.anhen.demo1.model.Page;
import com.quartz.demo5.QuartzJob;
import com.quartz.demo5.QuartzManage;
import com.quartz.demo5.mapper.QuartzJobMapper;
import com.quartz.demo5.service.QuartzJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

import static com.quartz.demo5.QuartzJob.*;

/**
 * @ClassName QuartzJobServiceImpl
 * @Description 定时任务
 * @Author wuxiaojian
 * @Date 2019/5/28 19:18
 * @Version 1.0
 **/
@Slf4j
@Service
public class QuartzJobServiceImpl implements QuartzJobService {
    @Resource
    QuartzJobMapper quartzJobMapper;
    @Resource
    QuartzManage quartzManage;


    @PostConstruct
    public void init(){
        //项目启动时初始化所有任务状态为停止状态
        updateAll();
        //查询需要启动的定时任务
        List<QuartzJob> quartzJobList = listStartUp();
        for (QuartzJob quartzJob : quartzJobList){
            try {
                quartzManage.addJob(quartzJob);
                quartzJob.setJobStatus(STATUS_RUNNING);
                quartzJobMapper.update(quartzJob);
            } catch (Exception e){
                log.error(String.format("启动任务%s失败",quartzJob.getJobName()), e);
            }
        }
    }


    @Override
    public QuartzJob[] list() {
        return quartzJobMapper.list();
    }

    @Override
    public List<QuartzJob> pageList(Page page) {
        return quartzJobMapper.pageList(page);
    }

    @Override
    public int total() {
        return quartzJobMapper.total();
    }

    @Override
    public QuartzJob get(Integer id) {
        return quartzJobMapper.get(id);
    }

    @Override
    public int add(QuartzJob quartzJob) {

        return quartzJobMapper.add(quartzJob);
    }

    @Override
    public int update(QuartzJob quartzJob) {
        QuartzJob quartzJobOld = quartzJobMapper.get(quartzJob.getId());
        try {
            if (!STATUS_STOP.equals(quartzJobOld.getJobStatus())){
                quartzManage.deleteJob(quartzJobOld);
            }
            quartzManage.addJob(quartzJob);
            quartzJob.setJobStatus(STATUS_RUNNING);
            quartzJobMapper.update(quartzJob);
        } catch (Exception e){
            log.error(String.format("更新任务%s失败",quartzJob.getJobName()), e);
        }
        return quartzJobMapper.update(quartzJob);
    }

    @Override
    public int delete(Integer... ids) {
        for (Integer id : ids){
            QuartzJob quartzJob = quartzJobMapper.get(id);
            if (quartzJob == null) continue;
            try {
                if (!STATUS_STOP.equals(quartzJob.getJobStatus())){
                    quartzManage.deleteJob(quartzJob);
                }
            } catch (Exception e){
                log.error(String.format("删除任务%s失败",quartzJob.getJobName()), e);
            }
        }
        return quartzJobMapper.delete(ids);
    }

    @Override
    public boolean startJob(Integer id){
        QuartzJob quartzJob = get(id);
        if (STATUS_STOP.equals(quartzJob.getJobStatus())){
            try {
                quartzManage.addJob(quartzJob);
                quartzJob.setJobStatus(STATUS_RUNNING);
                quartzJobMapper.update(quartzJob);
                return true;
            } catch (Exception e){
                log.error(String.format("启动任务%s失败",quartzJob.getJobName()), e);
            }
        }
        return false;
    }

    @Override
    public boolean stopJob(Integer id) {
        QuartzJob quartzJob = get(id);
        if(!STATUS_STOP.equals(quartzJob.getJobStatus())){
            try {
                quartzManage.deleteJob(quartzJob);
                quartzJob.setJobStatus(STATUS_STOP);
                quartzJobMapper.update(quartzJob);
                return true;
            } catch (Exception e){
                log.error(String.format("停止任务%s失败",quartzJob.getJobName()), e);
            }
        }
        return false;
    }

    @Override
    public boolean pauseJob(Integer id) {
        QuartzJob quartzJob = get(id);
        if(STATUS_RUNNING.equals(quartzJob.getJobStatus())){
            try {
                quartzManage.pauseJob(quartzJob);
                quartzJob.setJobStatus(STATUS_SUSPEND);
                quartzJobMapper.update(quartzJob);
                return true;
            } catch (Exception e){
                log.error(String.format("暂停任务%s失败",quartzJob.getJobName()), e);
            }
        }
        return false;
    }

    @Override
    public boolean resumeJob(Integer id) {
        QuartzJob quartzJob = get(id);
        if(STATUS_SUSPEND.equals(quartzJob.getJobStatus())){
            try {
                quartzManage.resumeJob(quartzJob);
                quartzJob.setJobStatus(STATUS_RUNNING);
                quartzJobMapper.update(quartzJob);
                return true;
            } catch (Exception e){
                log.error(String.format("恢复任务%s失败",quartzJob.getJobName()), e);
            }
        }
        return false;
    }

    @Override
    public int updateAll() {
        return quartzJobMapper.updateAll();
    }

    @Override
    public List<QuartzJob> listStartUp() {
        return quartzJobMapper.listStartUp();
    }
}
