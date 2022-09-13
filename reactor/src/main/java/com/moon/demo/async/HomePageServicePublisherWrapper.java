package com.moon.demo.async;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * @author wuxiaojian
 */
public class HomePageServicePublisherWrapper {
    private final HomePageService homePageService;
    /**
     * 线程池
     **/
    private final Scheduler executor = Schedulers.elastic();

    public HomePageServicePublisherWrapper(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    public Mono<String> getUserInfoAsync() {
        return Mono
                .fromCallable(this.homePageService::getUserInfo)
                .subscribeOn(this.executor);
    }

    public Mono<String> getNoticeAsync() {
        return Mono
                .fromCallable(this.homePageService::getNotice)
                .subscribeOn(this.executor);
    }

    public Mono<String> getTodosAsync(String userInfo) {
        return Mono
                .fromCallable(() -> this.homePageService.getTodos(userInfo))
                .subscribeOn(this.executor);
    }
}