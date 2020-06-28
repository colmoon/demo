package com.goldcard.designPattern.strategy.beforeModify;

public abstract class Role
{
	protected String name;
 
	protected abstract void display();
 
	protected abstract void run();
 
	protected abstract void attack();
 
	protected abstract void defend();
 
}
