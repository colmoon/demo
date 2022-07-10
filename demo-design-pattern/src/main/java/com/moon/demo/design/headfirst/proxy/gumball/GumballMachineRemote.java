package com.moon.demo.design.headfirst.proxy.gumball;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @ClassName GumballMachineRemote
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/18 17:42
 */
public interface GumballMachineRemote extends Remote {
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}
