package com.anhen.controller.model;

import lombok.Data;

/**
 * @ClassName Response
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/23 19:52
 * @Version 1.0
 **/
@Data
public class Response{
    /** 消息码 */
    private int code;
    /** 错误信息 */
    private String message;
    /** 返回数据 */
    private Object data;
}
