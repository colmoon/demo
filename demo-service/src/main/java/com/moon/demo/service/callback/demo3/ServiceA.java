package com.moon.demo.service.callback.demo3;

import com.moon.demo.service.designPattern.status.demo2.Yes;
import com.moon.demo.service.model.Response;

/**
 * @classname: ServiceA
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2024-01-16 08:39
 */
public class ServiceA {

    //同步方法
    public Response call() {
        return this.doBiz();
    }

    //异步方法
    public void callAsync(CallBack<Response> callBack) {
        new Thread(() -> {
            Response response = null;
            Throwable throwable = null;
            try {
                response = this.doBiz();
            } catch (Exception e) {
                throwable = e;
            }
            callBack.handle(response, throwable);
        }).start();
    }


    //业务逻辑
    private Response doBiz(){
        return new Response();
    }

}
