package com.quartz.demo5.mapper;

import com.anhen.demo1.model.Page;
import com.quartz.demo5.QuartzJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName QuartzJobMapper
 * @Description
 * @Author wuxiaojian
 * @Date 2019/5/28 19:13
 * @Version 1.0
 **/
@Mapper
public interface QuartzJobMapper {
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
    List<QuartzJob> pageList(@Param("page") Page page);


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
    QuartzJob get(@Param("id") Integer id);

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
    int delete(@Param("ids") Integer... ids);

    //初始化所有定时任务状态
    int updateAll();

    //查询项目启动需要立即启动的定时任务
    List<QuartzJob> listStartUp();
}
