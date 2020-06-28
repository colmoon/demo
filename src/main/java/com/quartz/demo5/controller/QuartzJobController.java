package com.quartz.demo5.controller;

import com.anhen.controller.model.Response;
import com.anhen.demo1.model.Page;
import com.quartz.demo5.QuartzJob;
import com.quartz.demo5.service.QuartzJobService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.quartz.demo5.service.ResponseBuilder.*;

/**
 * @ClassName QuartzJobController
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/28 19:20
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/api/protection/quartzJob")
@Validated
public class QuartzJobController {
    @Autowired
    private QuartzJobService quartzJobService;
    /**
     * 列表查询
     *
     * @param
     * @param page
     * @return
     */
    @ApiOperation(value = "定时任务列表", notes = "定时任务-定时任务列表",
            httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list(Page page) {
        List<QuartzJob> data = quartzJobService.pageList(page);
        int total = quartzJobService.total();
        return QUERY_SUCCESS.total(total).build(data);
    }
    /**
     * 详情查看
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "定时任务详情", notes = "定时任务-定时任务详情",
            httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response get(@PathVariable("id") int id) {
        QuartzJob data = quartzJobService.get(id);
        return QUERY_SUCCESS.build(data);
    }
    /**
     * 新增
     *
     * @param
     * @return
     */
    @ApiOperation(value = "定时任务新增", notes = "定时任务-定时任务新增",
            httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response add(@Validated @RequestBody QuartzJob quartzJob) {
        int id = quartzJobService.add(quartzJob);
        return INSERT_SUCCESS.build(id);
    }

    /**
     * 启动任务
     *
     * @param
     * @return
     */
    @ApiOperation(value = "启动定时任务", notes = "定时任务-启动定时任务",
            httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public Response startJob(@RequestBody Integer id) {
        boolean result = quartzJobService.startJob(id);
        return UPDATE_SUCCESS.build(result);
    }

    /**
     * 停止任务
     *
     * @param
     * @return
     */
    @ApiOperation(value = "停止定时任务", notes = "定时任务-停止定时任务",
            httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    public Response stopJob(@RequestBody Integer id) {
        boolean result = quartzJobService.stopJob(id);
        return UPDATE_SUCCESS.build(result);
    }

    /**
     * 暂停任务
     *
     * @param
     * @return
     */
    @ApiOperation(value = "暂停定时任务", notes = "定时任务-暂停定时任务",
            httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/pause", method = RequestMethod.POST)
    public Response pauseJob(@RequestBody Integer id) {
        boolean result = quartzJobService.pauseJob(id);
        return UPDATE_SUCCESS.build(result);
    }


    /**
     * 恢复任务
     *
     * @param
     * @return
     */
    @ApiOperation(value = "恢复定时任务", notes = "定时任务-恢复定时任务",
            httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/resume", method = RequestMethod.POST)
    public Response resumeJob(@RequestBody Integer id) {
        boolean result = quartzJobService.resumeJob(id);
        return UPDATE_SUCCESS.build(result);
    }

    /**
     * 修改任务
     *
     * @param id
     * @param
     * @return
     */
    @ApiOperation(value = "定时任务修改", notes = "定时任务-定时任务修改",
            httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Response update(@PathVariable("id") int id, @Validated @RequestBody QuartzJob quartzJob) {
        quartzJob.setId(id);
        int result = quartzJobService.update(quartzJob);
        if (result > 0) {
            return UPDATE_SUCCESS.build(true);
        } else {
            return UPDATE_ERROR.formatMsg("false").build(false);
        }
    }
    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "定时任务删除", notes = "定时任务-定时任务删除",
            httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.DELETE)
    public Response delete(@RequestBody Integer[] ids) {
        int result = quartzJobService.delete(ids);
        return DELETE_SUCCESS.build(result);
    }
}
