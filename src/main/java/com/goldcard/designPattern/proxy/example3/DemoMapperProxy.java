package com.goldcard.designPattern.proxy.example3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DemoMapperProxy<T> implements InvocationHandler {

    public T newInstance(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[] { clz }, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TestDemo testDemo = new TestDemo();
        testDemo.setId(1);
        testDemo.setName("proxyName");
        return testDemo;
    }

    public static void main(String[] args) {
        DemoMapperProxy<TestDemoMapper> demoMapperProxy = new DemoMapperProxy<TestDemoMapper>();
        TestDemoMapper testDemoMapper = demoMapperProxy.newInstance(TestDemoMapper.class);
        TestDemo byId = testDemoMapper.getById(1);
        System.out.println(byId);
    }
}