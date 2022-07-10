package com.moon.demo.service.designPattern.status.b;

public interface State
{
	/**
	 * 放钱
	 */
	void insertMoney();
	/**
	 * 退钱
	 */
	void backMoney();
	/**
	 * 转动曲柄
	 */
	void turnCrank();
	/**
	 * 出商品
	 */
	void dispense();
}