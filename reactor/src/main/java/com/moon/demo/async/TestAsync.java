package com.moon.demo.async;

import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;

/**
 * @classname: TestAsync
 * @description:
 * @author: wuxiaojian
 * @create: 2022-09-13 09:28
 */
public class TestAsync {

    public static void main(String[] args) throws InterruptedException {
//        completableFutureCall();
        publisherCall();
    }

    private static void completableFutureCall() throws InterruptedException {
        //用于让调用者线程等待多个异步任务全部结束
        CountDownLatch ct = new CountDownLatch(2);
        HomePageService homePageService = new HomePageService();
        HomePageServiceCompletableFutureWrapper homePageServiceCompletableFutureWrapper =
                new HomePageServiceCompletableFutureWrapper(homePageService);
        //统一的finallyCallback
        Runnable finallyCallback = ct::countDown;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        homePageServiceCompletableFutureWrapper
                .getUserInfoAsync()
                //依赖调用
                .thenCompose(userInfo -> {
                    System.out.println(userInfo);
                    return homePageServiceCompletableFutureWrapper.getTodosAsync(userInfo);
                })
                .thenAcceptAsync(System.out::println)
                .thenRun(finallyCallback);

        homePageServiceCompletableFutureWrapper
                .getNoticeAsync()
                .thenAcceptAsync(System.out::println)
                .thenRun(finallyCallback);
        //等待异步操作全部结束并统计耗时
        ct.await();
        stopWatch.stop();
        System.out.println("CompletableFuture async call methods costs " + stopWatch.getLastTaskTimeMillis() + " mills");

    }


    private static void publisherCall() throws InterruptedException {
        //用于让调用者线程等待多个异步任务全部结束
        CountDownLatch ct = new CountDownLatch(2);
        //统一的finallyCallback
        Runnable finallyCallback = ct::countDown;
        StopWatch stopWatch = new StopWatch();
        HomePageService homePageService = new HomePageService();
        HomePageServicePublisherWrapper homePageServicePublisherWrapper =
                new HomePageServicePublisherWrapper(homePageService);
        homePageServicePublisherWrapper
                .getUserInfoAsync()
                //由于初始化线程池很耗时，所以将stopWatch放置到此处
                //真是系统中，线程池应该提前初始化，而不应该用于一次性的方法
                .doOnSubscribe(subscription -> {
                    stopWatch.start();
                })
                //消费userInfo
                .doOnNext(System.out::println)
                //调用依赖于userInfo的getTodos
                .flatMap(homePageServicePublisherWrapper::getTodosAsync)
                //消费todos
                .doOnNext(System.out::println)
                .doFinally(s -> finallyCallback.run())
                .subscribe();

        homePageServicePublisherWrapper
                .getNoticeAsync()
                .doOnNext(System.out::println)
                .doFinally((s) -> {
                    finallyCallback.run();
                })
                .subscribe();
        ct.await();
        stopWatch.stop();
        System.out.println("Publisher async call methods costs " + stopWatch.getLastTaskTimeMillis() + " mills");
    }

}
