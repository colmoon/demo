package com.goldcard.designPattern.factory.a;
public class RouJiaMoStore
{
	private SimpleRouJiaMoFactroy factory;
	 
	public RouJiaMoStore(SimpleRouJiaMoFactroy factory)
	{
		this.factory = factory;
	}
 
	/**
	 * 根据传入类型卖不同的肉夹馍
	 * 
	 * @param type
	 * @return
	 */
	public RouJiaMo sellRouJiaMo(String type)
	{
		RouJiaMo rouJiaMo = factory.createRouJiaMo(type);
		rouJiaMo.prepare();
		rouJiaMo.fire();
		rouJiaMo.pack();
		return rouJiaMo;
	}
	
	public static void main(String[] args) {
		RouJiaMoStore store = new RouJiaMoStore(new SimpleRouJiaMoFactroy());
		RouJiaMo rouJiaMo = store.sellRouJiaMo("La");
	}
 
}
