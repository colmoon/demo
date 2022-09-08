package com.moon.demo.reactor;



import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.*;
import java.util.stream.Stream;

/**
 * @classname: TestReactor
 * @description: testReactor
 * @author: wuxiaojian
 * @create: 2022-09-05 13:34
 */
public class TestReactor {

    public static void main(String[] args) {
        //just()：创建Flux序列，并声明数据流，整形
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);
        //subscribe()：订阅Flux序列，只有进行订阅后才回触发数据流，不订阅就什么都不会发生
        integerFlux.subscribe(System.out::println);

        //字符串
        Flux<String> stringFlux = Flux.just("hello", "world");
        stringFlux.subscribe(System.out::println);

        //fromArray(),fromIterable()和fromStream()：可以从一个数组、Iterable 对象或Stream 对象中创建Flux序列
        Integer[] array = {1,2,3,4};
        Flux.fromArray(array).subscribe(System.out::println);

        List<Integer> integers = Arrays.asList(array);
        Flux.fromIterable(integers).subscribe(System.out::println);

        Stream<Integer> stream = integers.stream();
        Flux.fromStream(stream).subscribe(System.out::println);

        Mono<String> data = Mono.just("bole");

        Mono<String> noData = Mono.empty();

        data.subscribe(System.out::println);
        noData.subscribe(System.out::println);

        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);

        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if( list.size() == 10 ) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);

        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);

        Flux.create(sink -> {
            sink.next(Thread.currentThread().getName());
            sink.complete();
        }).publishOn(Schedulers.single())
                .map(x ->  String.format("[%s] %s", Thread.currentThread().getName(), x))
                .publishOn(Schedulers.elastic())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .subscribeOn(Schedulers.parallel())
                .toStream()
                .forEach(System.out::println);


    }


}
