package com.goldcard.designPattern.decorator;
public class YellowGemDecorator implements IEquipDecorator
{
	/**
	 * 每个装饰品维护一个装备
	 */
	private IEquip equip;
 
	public YellowGemDecorator(IEquip equip)
	{
		this.equip = equip;
	}
 
	@Override
    public int calculateAttack()
	{
		return 10 + equip.calculateAttack();
	}
 
	@Override
    public String description()
	{
		return equip.description() + "+ 黄宝石";
	}
 
}
