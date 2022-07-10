package com.moon.demo.service.designPattern.facade;

public class HomeTheaterFacade
{
	private Computer computer;
	private Player player;
	private Light light;
	private Projector projector;
	private PopcornPopper popper;
 
	public HomeTheaterFacade(Computer computer, Player player, Light light, Projector projector, PopcornPopper popper)
	{
		this.computer = computer;
		this.player = player;
		this.light = light;
		this.projector = projector;
		this.popper = popper;
	}
 
	public void watchMovie()
	{
		/**
		 *  1、打开爆米花机
			2、制作爆米花
			3、将灯光调暗
			4、打开投影仪
			5、放下投影仪投影区
			6、打开电脑
			7、打开播放器
			8、将播放器音调设为环绕立体声
		 */
		popper.on();
		popper.makePopcorn();
		light.down();
		projector.on();
		projector.open();
		computer.on();
		player.on();
		player.make3DListener();
	}
	
	public void stopMovie()
	{
		popper.off();
		popper.stopMakePopcorn();
		light.up();
		projector.close();
		projector.off();
		player.off();
		computer.off();
	}
	
	public static void main(String[] args) {
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(new Computer(), new Player(), new Light(), new Projector(), new PopcornPopper());
		homeTheaterFacade.watchMovie();
		homeTheaterFacade.stopMovie();
	}
}