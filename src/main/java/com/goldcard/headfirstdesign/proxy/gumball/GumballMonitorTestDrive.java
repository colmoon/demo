package com.goldcard.headfirstdesign.proxy.gumball;

import java.rmi.Naming;

/**
 * @ClassName GumballMonitorTestDrive
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/18 18:05
 */
public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        String[] location = {"rmi://127.0.0.1/gumballmachine"};

        GumballMonitor[] monitors = new GumballMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try{
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
                monitors[i] = new GumballMonitor(machine);
                System.out.println(monitors[i]);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

        for (int i = 0; i < monitors.length; i++) {
            monitors[i].report();
        }
    }
}
