/**  

* <p>Title: DoorOnCommand.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月9日  

* @version 1.0  

*/  
package com.goldcard.designPattern.command;

/**  

* <p>Title: DoorOnCommand</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月9日  

*/
public class DoorOnCommand implements Command {
	public Door door;
	
	public DoorOnCommand(Door door) {
		this.door = door;
	}
	
	/* (non-Javadoc)  
	
	 * <p>Title: execute</p>  
	
	 * <p>Description: </p>  
	  
	
	 * @see com.goldcard.designPattern.command.Command#execute()  
	
	 */
	@Override
    public void execute() {
		door.open();
	}

}
