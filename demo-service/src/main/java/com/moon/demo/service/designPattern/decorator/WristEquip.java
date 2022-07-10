package com.moon.demo.service.designPattern.decorator;
public class WristEquip implements IEquip
{
 
	@Override
    public int calculateAttack()
	{
		return 5;
	}
 
	@Override
    public String description()
	{
		return "圣战护腕";
	}
 
}
