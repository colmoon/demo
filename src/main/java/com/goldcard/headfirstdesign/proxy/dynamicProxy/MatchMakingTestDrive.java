package com.goldcard.headfirstdesign.proxy.dynamicProxy;

import com.goldcard.serial.Person;

import java.lang.reflect.Proxy;

/**
 * @ClassName MatchMakingTestDrive
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/19 21:11
 */
public class MatchMakingTestDrive {

    public static void main(String[] args) {
        MatchMakingTestDrive testDrive = new MatchMakingTestDrive();
        testDrive.drive();
    }

    public void drive(){
        PersonBean joe = new PersonBeanImpl("Joe Javabean");
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        ownerProxy.setInterests("bowling, Go");
        System.out.println("Interests set from owner Proxy");
        try{
            ownerProxy.setHotOrNotRating(10);
        }catch (Exception ex){
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try{
            nonOwnerProxy.setInterests("bowling, Go");
        }catch (Exception ex){
            System.out.println("Can't set rating from owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
    }

    public PersonBean getOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    public PersonBean getNonOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }
}
