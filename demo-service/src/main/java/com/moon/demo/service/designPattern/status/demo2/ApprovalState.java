package com.moon.demo.service.designPattern.status.demo2;

import lombok.Getter;

/**
 * @Author wuxiaojian
 * @Description //枚举
 * @Date  2019/7/19 10:40
 * @Param
 * @return
 **/

@Getter
public enum ApprovalState {
    YES(1,"yes"),
    NO(2,"no"),
    CANCEL(3,"cancel");

    //成员变量
    private int code;
    private String name;

    //构造函数
    ApprovalState(int code,String name){
        this.code = code;
        this.name = name;
    }

    public ApprovalState getApprovalStateByCode(int code) {
        for (ApprovalState causeEnum : ApprovalState.values()) {
            if (code == causeEnum.getCode()) {
                return causeEnum;
            }
        }
        return null;
    }

}
