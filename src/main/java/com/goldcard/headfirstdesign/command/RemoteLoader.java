package com.goldcard.headfirstdesign.command;



/**
 * @ClassName RemoteLoader
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/11 9:44
 */
public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();

        CeilingFan ceilingFan = new CeilingFan("LivingRoom");

        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(2, ceilingFanHighCommand, ceilingFanOffCommand);
        remoteControl.setCommand(3, ceilingFanMediumCommand, ceilingFanOffCommand);

        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(2);
        remoteControl.undoButtonWasPushed();

        Command[] partyOn = {livingRoomLightOn, kitchenLightOn, ceilingFanHighCommand};
        Command[] partyOff = {livingRoomLightOff, kitchenLightOff,ceilingFanOffCommand};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remoteControl.setCommand(4, partyOnMacro, partyOffMacro);

        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);


        System.out.println(remoteControl);


    }
}
