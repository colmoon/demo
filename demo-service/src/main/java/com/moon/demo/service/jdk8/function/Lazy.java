package com.moon.demo.service.jdk8.function;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @classname: Lazy
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-01 18:31
 */
public class Lazy<T> implements Supplier<T> {

    private final Supplier<? extends T> supplier;

    // 利用 value 属性缓存 supplier 计算后的值
    private T value;

    private Lazy(Supplier<? extends T> supplier){
        this.supplier = supplier;
    }

    public static <T> Lazy<T> of(Supplier<? extends T> supplier){
        return new Lazy<>(supplier);
    }

    @Override
    public T get() {
        if (value == null){
            T newValue = this.supplier.get();

            if (newValue == null){
                throw new IllegalStateException("Lazy value can not be null");
            }

            value = newValue;
        }

        return value;
    }

    /**
     * 函子运算可以将一个 T 映射到 S 的 function 应用到 Box<T> 上，让其成为 Box<S>
     * @param function:
     * @return: com.jdk8.function.Lazy<S>
     **/
    public <S> Lazy<S> map(Function<? super T, ? extends S> function){
        return Lazy.of(() -> function.apply(get()));
    }


    /**
     * 单子和函子的重大区别在于接收的函数，函子的函数一般返回的是原生的值，而单子的函数返回却是一个盒装的值
     * @param function:
     * @return: com.jdk8.function.Lazy<S>
     **/
    public <S> Lazy<S> flatMap(Function<? super T, Lazy<? extends S>> function){
        return Lazy.of(() -> function.apply(get()).get());
    }


    
}
