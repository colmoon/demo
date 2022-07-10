package com.moon.demo.service.designPattern.decorator;
public interface IEquip
{
 
	/**
	 * 计算攻击力
	 * 
	 * @return
	 */
	int calculateAttack();
 
	/**
	 * 装备的描述
	 * 
	 * @return
	 */
	String description();
}