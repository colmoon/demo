package com.moon.demo.design.headfirst.compound;


public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}
