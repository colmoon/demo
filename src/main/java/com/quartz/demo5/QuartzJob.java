package com.quartz.demo5;

import lombok.Data;

/**
 * @author xup
 * @since 2018-01-29
 */
@Data
public class QuartzJob {

	public static final String STATUS_RUNNING = "02";
	public static final String STATUS_SUSPEND = "01";
	public static final String STATUS_STOP = "00";
	public static final String CRON_TRIGGER = "00";
	public static final String SIMPLE_TRIGGER = "01";

	/** 主键 */
	private Integer id;
	/** 包名+类名 */
	private String beanName;
	/** 任务名 */
	private String jobName;
	/** 任务组 */
	private String jobGroup;
	/** 触发器名称 */
	private String triggerName;
	/** 触发器组 */
	private String triggerGroup;
	/** 初始延迟时间 单位秒**/
	private Integer delay;
	/** cron表达式 */
	private String cronExpression;
	/** 任务状态 */
	private String jobStatus;
	/** 触发器类型 **/
	private String triggerType;
	/** simple_trigger 时间间隔 **/
	private int simpleTriggerInterval;
	/**	simple_trigger 执行次数 **/
	private int simpleTriggerCount;
	/** 任务描述 */
	private String description;
	/** 创建时间 */
	private String createTime;
	/** 修改时间 */
	private String updateTime;
	/** 是否随项目启动 */
	/** '00'不随项目启动，'01'随项目启动*/
	private String startUp;
}