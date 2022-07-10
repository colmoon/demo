package com.moon.demo.service.designPattern.command;

public class LightOnCommond implements Command
{
	private Light light ; 
	
	public LightOnCommond(Light light)
	{
		this.light = light;
	}
 
	@Override
    public void execute()
	{
		light.on();
	}
 
}
