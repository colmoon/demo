package com.moon.demo.service.designPattern.decorator;
public class RedGemDecorator implements IEquipDecorator
{
	/**
	 * 每个装饰品维护一个装备
	 */
	private IEquip equip;
 
	public RedGemDecorator(IEquip equip)
	{
		this.equip = equip;
	}
 
	@Override
    public int calculateAttack()
	{
		return 15 + equip.calculateAttack();
	}
 
	@Override
    public String description()
	{
		return equip.description() + "+ 红宝石";
	}
 
}
