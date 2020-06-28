package com.goldcard.headfirstdesign.compound;


public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}
