package com.moon.demo.async;

import java.util.concurrent.CompletableFuture;

/**
 * @author wuxiaojian
 */
public class HomePageServiceCompletableFutureWrapper {
    private final HomePageService homePageService;

    public HomePageServiceCompletableFutureWrapper(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    CompletableFuture<String> getUserInfoAsync() {
        return CompletableFuture.supplyAsync(this.homePageService::getUserInfo);
    }

    CompletableFuture<String> getNoticeAsync() {
        return CompletableFuture.supplyAsync(this.homePageService::getNotice);
    }

    CompletableFuture<String> getTodosAsync(String userInfo) {
        return CompletableFuture.supplyAsync(() -> this.homePageService.getTodos(userInfo));
    }
}