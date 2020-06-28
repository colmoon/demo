package com.quartz.demo5.service;


import com.anhen.demo1.model.Page;
import com.quartz.demo5.QuartzJob;

import java.util.List;

/**
 * @ClassName QuartzJobService
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/28 19:16
 * @Version 1.0
 **/

public interface QuartzJobService {
    /**
     * 列表
     *
     * @param
     * @return
     */
    QuartzJob[] list();


    /**
     * 列表
     *
     * @param
     * @return
     */
    List<QuartzJob> pageList(Page page);


    /**
     * 查询记录数，分页使用
     *
     * @param
     * @return
     */
    int total();

    /**
     * 查询
     *
     * @param
     * @return
     */
    QuartzJob get(Integer id);

    /**
     * 添加
     *
     * @param
     * @return
     */
    int add(QuartzJob quartzJob);

    /**
     * 更新
     *
     * @param
     * @return
     */
    int update(QuartzJob quartzJob);

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    int delete(Integer... ids);

    //启动任务
    boolean startJob(Integer id);

    //停止任务
    boolean stopJob(Integer id);

    //暂停任务
    boolean pauseJob(Integer id);

    //恢复任务
    boolean resumeJob(Integer id);

    //初始化所有定时任务状态
    int updateAll();

    //查询项目启动需要立即启动的定时任务
    List<QuartzJob> listStartUp();
}
