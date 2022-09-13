package com.moon.demo.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

public class BackpressureDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        //可以观察到明显的限流
        Flux<Long> flux = Flux.interval(Duration.ofMillis(50))
                .take(50)
                .doOnComplete(countDownLatch::countDown);
        flux.subscribe(new MyLimitedSubscriber(5));
        countDownLatch.await();

        //使用比count还大的limiter，相当于不限流
        System.out.println("use big limiter");
        Flux.interval(Duration.ofMillis(50))
                .take(50)
                .subscribe(new MyLimitedSubscriber(100));
    }
}