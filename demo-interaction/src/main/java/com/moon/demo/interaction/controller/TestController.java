package com.moon.demo.interaction.controller;

import com.moon.demo.service.filter.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestController
 * @Description
 * @Author wuxiaojian
 * @Date 2019/8/20 15:40
 * @Version 1.0
 **/
@RestController
public class TestController {

    @ApiOperation(value = "过滤器测试fail", notes = "",
            httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/failed",method = RequestMethod.GET)
    public Map<String, String> requestFailed(){

        Map<String, String> map = new HashMap<>();
        map.put("code", "-1");
        map.put("msg", "请求错误");
        return map;
    }

    @ApiOperation(value = "过滤器测试success", notes = "",
            httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/success/info",method = RequestMethod.GET)
    public User userInfo(){

        User user = new User();
        user.setUserName("Yansir");
        user.setPassword("");
        user.setNickName("cherish");
        user.setGender("女");
        user.setAge("1");
        return user;
    }
}
