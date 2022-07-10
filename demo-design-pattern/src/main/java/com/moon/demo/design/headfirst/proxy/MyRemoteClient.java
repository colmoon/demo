package com.moon.demo.design.headfirst.proxy;

import java.rmi.Naming;

/**
 * @ClassName MyRemoteClient
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/18 16:12
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go(){
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello" );
            String string = service.sayHello();
            System.out.println(string);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
