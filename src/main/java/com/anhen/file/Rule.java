package com.anhen.file;

import lombok.Data;

@Data
public class Rule{
    /** 主键 */
    private Integer id;
    /** 规则ID */
    private String ruleId;
    /** 规则名称 */
    private String ruleName;
    /** 应用协议 */
    private String protocol;
    /** 规则等级 */
    private String ruleLevel;
    /** 规则类型 */
    private String ruleType;
    /** CVE编号 */
    private String cveNumber;
    /** 启用状态;00不启用，01启用 */
    private String enableState;
    /** 受影响系统 */
    private String affectedSystem;
    /** 攻击者 */
    private String attacker;
    /** 受攻击目标 */
    private String attackedTarget;
    /** 受攻击位置 */
    private String attackedLocation;
    /** 规则描述 */
    private String ruleDescription;
    /** 解决方案 */
    private String solution;
    /** 参考链接 */
    private String referenceLink;
    /** 创建时间 */
    private String createTime;
    /** 更改时间 */
    private String updateTime;
}