package com.moon.demo.design.headfirst.proxy.gumball;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @ClassName GumballMachineTestDrive
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/18 9:50
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachineRemote gumballMachine = null;
        int count;
//        if(args.length < 2){
//            System.out.println("GumballMachine <name> <inventory>");
//            System.exit(1);
//        }

        try {
            count = 100;
            String location = "santafe.mightygumball.com";
            LocateRegistry.createRegistry(1099);
            gumballMachine = new GumballMachine(location, count);
            Naming.rebind("/gumballmachine", gumballMachine);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
