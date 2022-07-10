package com.moon.demo.design.headfirst.proxy.gumball;

import java.rmi.RemoteException;

/**
 * @ClassName GumballMonitor
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/18 18:02
 */
public class GumballMonitor {
    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report(){
        try {
            System.out.println("Gumball Machine: " + machine.getLocation());
            System.out.println("Current inventory: " + machine.getCount());
            System.out.println("Current state: " + machine.getState());
        } catch (RemoteException ex){
            ex.printStackTrace();
        }
    }
}
