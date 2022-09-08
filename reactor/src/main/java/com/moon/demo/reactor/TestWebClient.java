package com.moon.demo.reactor;

import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @classname: TestWebClient
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2022-09-06 17:13
 */
public class TestWebClient {

    private static WebClient client;


    public static void init() {
        //创建webclient实例
        client = WebClient.builder(). build();
    }


    public static void main(String[] args) throws InterruptedException {


        //1.初始化webclient
        init();


        //2.反应式调用，返回reactor流对象
        Mono<Object> resp = client
                .method(HttpMethod.GET)
                .uri("http://192.168.30.152:8888/api/auth/web/user/auth")
                .retrieve()
                .bodyToMono(Object.class);


        //3.订阅流对象
        resp.onErrorMap(throwable -> {
            System.out.println("onErrorMap:" + throwable.getLocalizedMessage());
            return throwable;
        }).subscribe(s -> System.out.println("result:" + Thread.currentThread().getName() + " " + s));

        Thread.sleep(3000);
        //4.调用线程打印
        System.out.println("main is over");
    }

}
