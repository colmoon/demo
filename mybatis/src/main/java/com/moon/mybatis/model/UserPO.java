package com.moon.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户实体
 * @author baiyan
 * @date 2020/11/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPO {

    private long id;

    /** 用户名 */
    private String userName;

    /** 秦政通人员id,唯一标识 */
    private String staffId;

    /** 真是姓名 */
    private String realName;

    /** 头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 密码 */
    private String ip;

    /** 手机号 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 微信 */
    private String weChat;

    /**
     * 状态
     * */
    private Integer state;

    /** 锁定截止时间 */
    private LocalDateTime lockLimitTime;

    /** 锁定次数 */
    private Integer lockTimes;

    /** 上次登录时间 */
    private LocalDateTime lastLoginTime;

    /** 能否编辑 */
    private Integer canEdit;

    /** 能否删除 */
    private Integer canDelete;

    /** 是否为系统内置用户：1可见，0不可见 */
    private Integer visibility;

    /** 是否需要重置密码 */
    private Integer needResetPassword;

    /**
     * 产品来源
     */
    private String productName;

}
