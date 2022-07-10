package com.moon.demo.design.headfirst.state;

/**
 * @ClassName GumballMachineTestDrive
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/18 9:50
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnQuarter();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnQuarter();

        System.out.println(gumballMachine);
    }
}
