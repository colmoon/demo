package com.moon.demo.service.designPattern.command;
public class ComputerOffCommand implements Command
{
	private Computer computer ; 
	
	public ComputerOffCommand( Computer computer)
	{
		this.computer = computer;
	}
 
	@Override
    public void execute()
	{
		computer.off();
	}
	
	
 
}
