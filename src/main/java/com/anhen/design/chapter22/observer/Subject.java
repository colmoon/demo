package com.anhen.design.chapter22.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: Subject
 * @description: 抽象主题，这里用抽象类，根据实际情况也可以用接口
 * @author: wuxiaojian
 * @create: 2021-11-08 18:46
 */
public abstract class Subject {
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void deleteObserver(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(){
        observerList.forEach(Observer::update);
    }
}
