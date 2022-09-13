import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @classname: FluxTest
 * @description: Flux mono test
 * reactive streams标准核心接口有3个：
 *
 * Publisher<T>
 * Subscriber<T>
 * Subscription
 *
 * @author: wuxiaojian
 * @create: 2022-09-09 10:11
 */
public class FluxTest {

    /**
     *
     集合Operator：提供集合运算，如map、filter、sort、group、reduce等，和java 8 Stream的中间操作具有相同的效果。
     异常处理Operator：提供异常处理机制，如retry、onErrorReturn等。
     回调Operator：提供Publisher状态状态转换时的回调，如doOnCancel、doOnRequest等。
     行为Operator：修改Publisher的默认行为，为其添加更多功能，如buffer、defaultIfEmpty、onBackpressureXXX等。
     调试Operator：添加调试信息，如log、elapsed等
     * @return: void
     **/
    @Test
    public void test(){
        //just()：创建Flux序列，并声明数据流，整形
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);
        //subscribe()：订阅Flux序列，只有进行订阅后才回触发数据流，不订阅就什么都不会发生
        integerFlux.subscribe(System.out::println);

        //字符串
        Flux<String> stringFlux = Flux.just("hello", "world");
        stringFlux.subscribe(System.out::println);

        Flux.range(1, 10).subscribe(System.out::println);

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

        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);

    }

    @Test
    public void intervalTest() throws InterruptedException {
        Flux.interval(Duration.of(1, ChronoUnit.SECONDS)).subscribe(System.out::println);
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void bufferTest(){
        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
        Flux.range(1, 10).bufferUntil(i -> i%2 == 0).subscribe(System.out::println);
        Flux.range(1, 10).bufferWhile(i -> i%2 == 0).subscribe(System.out::println);
    }


    @Test
    public void zipWithTest(){
        Flux.just("a", "b").zipWith(Flux.just("c", "d")).subscribe(System.out::println);
        Flux.just("a", "b").zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2)).subscribe(System.out::println);
    }

    /**
     *
     * 当序列的生成需要复杂的逻辑时，则应该使用generate()或create()方法。
     * generate()方法通过同步和逐一的方式来产生Flux序列。
     * 序列的产生是通过调用所提供的的SynchronousSink对象的next()，complete()和error(Throwable)方法来完成的。
     * 逐一生成的含义是在具体的生成逻辑中，next()方法只能最多被调用一次。
     * @return: void
     **/
    @Test
    public void generateTest(){
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
    }

    /**
     * create()方法与generate()方法的不同之处在于所使用的是FluxSink对象。
     * FluxSink支持同步和异步的消息产生，并且可以在一次调用中产生多个元素。
     * 通过调度器可以指定操作执行的方式和所在的线程。有以下几种不同的调度器实现
     * 当前线程，通过Schedulers.immediate()方法来创建
     * 单一的可复用的线程，通过Schedulers.single()方法来创建
     * 使用弹性的线程池，通过Schedulers.elastic()方法来创建。线程池中的线程是可以复用的。当所需要时，新的线程会被创建。若一个线程闲置时间太长，则会被销毁。该调度器适用于I/O操作相关的流的处理
     * 使用对并行操作优化的线程池，通过Schedulers.parallel()方法来创建。其中的线程数量取决于CPU的核的数量。该调度器适用于计算密集型的流的处理
     * 使用支持任务调度的调度器，通过Schedulers.timer()方法来创建
     * 通过publishOn()和subscribeOn()方法可以切换执行操作调度器。publishOn()方法切换的是操作符的执行方式，而subscribeOn()方法切换的是产生流中元素时的执行方式
     * @return: void
     **/
    @Test
    public void createTest(){
        //create()方法与generate()方法的不同之处在于所使用的是FluxSink对象
        Flux.create(sink -> {
            for(int i = 0; i < 10; i ++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);

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


    /**
     * take系列操作符用来从当前流中提取元素。提取方式如下：
     * take(long n)，take(Duration timespan)和takeMillis(long timespan)：按照指定的数量或时间间隔来提取
     * takeLast(long n)：提取流中的最后N个元素
     * takeUntil(Predicate<? super T> predicate) ：提取元素直到Predicate返回true
     * takeWhile(Predicate<? super T> continuePredicate)：当Predicate返回true时才进行提取
     * takeUntilOther(Publisher<?> other)：提取元素知道另外一个流开始产生元素
     * @return: void
     **/
    @Test
    public void takeTest(){
        Flux.range(1, 1000).take(10).subscribe(System.out::println);
        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);
    }

    /**
     *
     如果对Java 8 Stream比较熟悉，可以将Operator类比为Stream的中间操作，将subscribe类比为Stream的终结操作。
     同时，如果对函数编程比较熟悉的话，也可以看出Operator、Subscriber都是典型的函数，接收输入进行计算给出输出，并且计算时并不会修改输入的值。
     * @return: void
     **/
    @Test
    public void reduceTest(){
        Flux.range(1, 100).reduce(Integer::sum).subscribe(System.out::println);
        Flux.range(1, 100).reduceWith(() -> 100, Integer::sum).subscribe(System.out::println);
    }

    /**
     *
     * map函数会对每一条输入进行指定的操作，然后为每一条输入返回一个对象。 而flatMap函数则是两个操作的集合——正是“先映射后扁平化”：
     * 操作1：同map函数一样：对每一条输入进行指定的操作，然后为每一条输入返回一个对象
     * 操作2：最后将所有对象合并为一个对象
     * @return: void
     **/
    @Test
    public void mapTest(){
        Flux<String> ids = Flux.just("1", "2");

        Flux<Mono<String>> map = ids.map(id -> {
            Mono<String> nameTask = getName(id);
            Mono<Integer> ageTask = getAge(id);
            return nameTask.zipWith(ageTask, (name, age) -> name + " is " + age + " years old");
        });

        Mono<String> stringMono = map.blockFirst();
        String result = stringMono.block();
        System.out.println(result);
    }

    @Test
    public void flatMapTest(){
        Flux<String> ids = Flux.just("1", "2");
        Flux<String> combinations = ids.flatMap(id -> {
            Mono<String> nameTask = getName(id);
            Mono<Integer> ageTask = getAge(id);
            return nameTask.zipWith(ageTask, (name, age) -> name + " is " + age + " years old");
        });
        Mono<List<String>> result = combinations.collectList();
        List<String> block = result.block();
        System.out.println(block);
    }

    protected static Mono<String> getName(String id){
        if ("1".equals(id)){
            return Mono.just("Tom");
        } else if ("2".equals(id)){
            return Mono.just("Jack");
        } else {
            return Mono.just("Susan");
        }
    }

    protected static Mono<Integer> getAge(String id){
        if ("1".equals(id)){
            return Mono.just(10);
        } else if ("2".equals(id)){
            return Mono.just(11);
        } else {
            return Mono.just(12);
        }
    }

    @Test
    public void subscriberTest() throws InterruptedException {
        Subscriber<Object> subscriber = new Subscriber<Object>() {
            Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
                this.subscription = subscription;
                subscription.request(1);
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext value is " + o);
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError exception message is " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        System.out.println("start data---------");
        Flux.just("1", "2").subscribe(subscriber);

        System.out.println("start empty---------");
        Flux.empty().subscribe(subscriber);

        System.out.println("start error---------");
        Flux.error(new RuntimeException("my exception")).subscribe(subscriber);

        System.out.println("start never---------");
        Flux.never().subscribe(subscriber);
    }

    /**
     * 通过调度器可以指定操作执行的方式和所在的线程。有以下几种不同的调度器实现
     * 当前线程，通过Schedulers.immediate()方法来创建
     * 单一的可复用的线程，通过Schedulers.single()方法来创建
     * 使用弹性的线程池，通过Schedulers.elastic()方法来创建。线程池中的线程是可以复用的。当所需要时，新的线程会被创建。若一个线程闲置时间太长，则会被销毁。该调度器适用于I/O操作相关的流的处理
     * 使用对并行操作优化的线程池，通过Schedulers.parallel()方法来创建。其中的线程数量取决于CPU的核的数量。该调度器适用于计算密集型的流的处理
     * publishOn会让之后的操作在Scheduler提供的线程中执行，
     * subscribeOn会让之前的操作在Scheduler提供的线程中执行
     * //
     * Publisher号称是异步的事件流，Java里面单线程是没法异步的，同时号称底层是否使用并发对上层是透明的(即Publisher本身不会显式创建、操作线程的)，所以Publisher具有若干切换代码执行上下文（其实就是线程）的方法。
     * Reactor使用reactor.core.scheduler.Scheduler对执行一个异步执行的操作进行抽象，底层使用ExecutorService或者ScheduledExecutorService执行这个异步操作。
     * Reactor提供了多种Scheduler实现，并提供了工厂类reactor.core.scheduler.Schedulers方便开发者使用。
     * Publisher则提供了publishOn和subscribeOn两个方法设置要使用的Scheduler。
     * @return: void
     **/
    @Test
    public void publishTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Flux.range(1, 20)
                //使用Schedulers.parallel()线程池执行之后的操作
                .publishOn(Schedulers.parallel())
                .doOnComplete(countDownLatch::countDown)
                .subscribe(i -> {
                    System.out.println("Current Thread is "
                            + Thread.currentThread().getName() + ", value " + i);
                });
        //如果使用了Scheduler，则subscribe是异步的，主线程必须阻塞才行
        System.out.println(Thread.currentThread().getName() + "-Main thread blocking");
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "-Flow complete,Main thread run and finished");

    }

    @Test
    public void publishOnThreadTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Flux.range(1, 20)
                .map(i -> {
                    System.out.println("map in Thread " + Thread.currentThread().getName() +" value is " + i);
                    return ++i;
                })
                //使用Schedulers.parallel()线程池执行之后的操作
                .publishOn(Schedulers.parallel())
                .doOnComplete(countDownLatch::countDown)
                .subscribeOn(Schedulers.single())
                .subscribe(i -> {
                    System.out.println("Current Thread is "
                            + Thread.currentThread().getName() + ", value " + i);
                });
        //如果使用了Scheduler，则subscribe是异步的，主线程必须阻塞才行
        System.out.println(Thread.currentThread().getName() + "-Main thread blocking");
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "-Flow complete,Main thread run and finished");
    }

    @Test
    public void expectTest() {
        StepVerifier.create(Flux.just("one", "two","three"))
                //依次校验每一步的数据是否符合预期
                .expectNext("one")
                .expectNext("two")
                .expectNext("three")
                //校验Flux流是否按照预期正常关闭
                .expectComplete()
                //启动
                .verify();
    }




}
