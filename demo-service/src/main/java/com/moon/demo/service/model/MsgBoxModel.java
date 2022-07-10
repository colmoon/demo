package com.moon.demo.service.model;

import lombok.Data;

/**
 * @ClassName MsgBoxModel
 * @Description MsgBoxModel
 * @Author wuxiaojian
 * @Date 2019/4/23 13:31
 * @Version 1.0
 **/

@Data
public class MsgBoxModel {

    /**
     *  code.
     */
    private Integer code;

    /**
     *  message.
     */
    private String message;

    /**
     *  data.
     */
    private Object data;

    public MsgBoxModel(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

