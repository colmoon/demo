package com.anhen.rateLimit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @ClassName TestRateLimiter
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/7/3 16:03
 * @Version 1.0
 **/

public class TestRateLimiter {

    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(5);
//        System.out.println(limiter.acquire(3));
        for(int i = 0; i < 5;i++) {
            System.out.println(limiter.tryAcquire());
        }
    }
}
