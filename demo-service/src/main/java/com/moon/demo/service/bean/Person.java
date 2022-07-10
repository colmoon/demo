package com.moon.demo.service.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * @classname: Person
 * @description: Person
 * @author: wuxiaojian
 * @create: 2020-05-09 10:20
 */
public class Person extends InstantiationAwareBeanPostProcessorAdapter implements BeanFactoryAware, BeanNameAware,
        InitializingBean, DisposableBean, ApplicationContextAware {

    /**
     * Bean的完整生命周期从 spring 容器开始实例化 bean 开始，到销毁。可以从三点来理解
     *
     * 1、 bean自身的方法：包括构造方法、 set 方法、 init-method 指定的方法、 destroy-method 指定的方法
     *
     * 2、 Bean级生命周期接口方法：如 BeanNameAware 、 BeanFactoryAware 等这些接口方法由 bean类实现。
     *
     * 3、 容器级生命周期接口方法：有InstantiationAwareBeanPostProcessor 、 BeanPostProcessor 等。一般称为后处理 器。他们一般不由bean 本身实现，独立存在，注册到 spring 容器中。 Spring 通过接口反射预先知道，当 spring 容器创建任何 bean 时，这些后处理器都会发生作用。所以他们是全局的，用户可以通过编码对只感兴趣的 bean 进行处理。
     **/

    /**
     * 【构造器】调用Person的构造器实例化
     * 【BeanNameAware接口】调用BeanNameAware.setBeanName()
     * 【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()
     * 【setApplicationContext】方法
     * 【@PostConstruct】 注解
     * 【InitializingBean接口】调用InitializingBean.afterPropertiesSet()
     * 【init-method】调用<bean>的init-method属性指定的初始化方法
     **/

    private String name;
    private String address;
    private int phone;

    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("【构造器】调用Person的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("【注入属性】注入属性address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.out.println("【注入属性】注入属性phone");
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + ", phone="
                + phone + "]";
    }

    /*@Override
    public boolean postProcessAfterInstantiation(final Object bean, final String beanName) throws BeansException {
        System.out.println("【postProcessAfterInstantiation】方法");
        System.out.println(bean);
        System.out.println(beanName);
        return super.postProcessAfterInstantiation(bean, beanName);
    }*/


    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String arg) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = arg;
        System.out.println(arg);
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = arg;
        System.out.println(beanFactory);
        /** 如果此时没有加载student，会先去加载student */
        /*Student student = beanFactory.getBean(Student.class);
        System.out.println(student.getAge());
        System.out.println(student.getName());*/
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("【@PostConstruct】 注解");
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out
                .println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【setApplicationContext】方法");
        /** 如果此时没有加载student，会先去加载student */
        /*Student student = applicationContext.getBean(Student.class);
        System.out.println(student.getAge());
        System.out.println(student.getName());*/
    }

    // 这是DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestroy() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}
