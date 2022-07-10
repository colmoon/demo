package com.moon.demo.service.designPattern.decorator;

public class ShoeEquip implements IEquip
{
 
	@Override
    public int calculateAttack()
	{
		return 5;
	}
 
	@Override
    public String description()
	{
		return "圣战靴子";
	}
 
}
