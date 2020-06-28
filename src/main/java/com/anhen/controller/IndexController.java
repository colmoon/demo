package com.anhen.controller;

import com.anhen.controller.annocation.AnalysisActuator;
import com.anhen.controller.annocation.SysLog;
import com.anhen.controller.model.MsgBoxModel;
import com.anhen.controller.model.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.anhen.controller.model.ResponseBuilder.UPDATE_ERROR;
import static com.anhen.controller.model.ResponseBuilder.UPDATE_SUCCESS;


/**
 * @ClassName IndexController
 * @Description
 * @Author wuxiaojian
 * @Date 2019/4/23 13:11
 * @Version 1.0
 **/

@RestController
@RequestMapping(value = "/api")
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    private static final int SIZE_1M = 1024*1024;
    /**
     * 自定义请求执行状态编码.
     */
    public static final Integer CODE_FAILURE = -1;
    public static final Integer CODE_SUCCESS = 0;

    @ApiOperation(value = "JVM内存分配", notes = "JVM内存分配",
            httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = HttpStatus.SC_OK, message = "请求已经受理, 执行结果见返回码"),
            @ApiResponse(code = HttpStatus.SC_BAD_REQUEST, message = "传递参数非法"),
            @ApiResponse(code = HttpStatus.SC_INTERNAL_SERVER_ERROR, message = "服务器异常"),
    })
    @AnalysisActuator(note = "获取JVM内存分配方法")
    @SysLog(value = "获取JVM内存分配方法")
    @RequestMapping(value = "/bug", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MsgBoxModel> allocationMem(@RequestParam(value = "num") int num) {
        try {
            for (int i = 0; i < num; i++){
                byte[] mem = new byte[num * SIZE_1M];
            }
            logger.info("内存分配成功, ioc: {}", num);
            return ResponseEntity.status(HttpStatus.SC_OK).body(new MsgBoxModel(CODE_SUCCESS
                    , "内存分配成功", "test"));
        } catch (Exception e) {
            logger.error("内存分配失败", e);
            return ResponseEntity.status(HttpStatus.SC_OK).body(
                    new MsgBoxModel(CODE_FAILURE, "内存分配失败", null));
        }
    }



    @ApiOperation(value = "JVM内存分配2", notes = "JVM内存分配2",
            httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @AnalysisActuator(note = "获取JVM内存分配方法2")
    @SysLog(value = "获取JVM内存分配方法2")
    @RequestMapping(value = "/bug2", method = RequestMethod.POST)
    @ResponseBody
    public Response allocationMem2(@RequestParam(value = "num") int num) {
        try {
            for (int i = 0; i < num; i++){
                byte[] mem = new byte[num * SIZE_1M];
            }
            logger.info("内存分配成功, ioc: {}", num);
            return UPDATE_SUCCESS.message("内存分配成功").build(true);
        } catch (Exception e) {
            logger.error("内存分配失败", e);
            return UPDATE_ERROR.build(false);
        }
    }
}
