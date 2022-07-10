package com.moon.demo.design.headfirst.compound.mvc;

/**
 * @ClassName HeartModelInterface
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/26 20:57
 */
public interface HeartModelInterface {
    int getHeartRate();
    void registerObserver(BeatObserver observer);
    void removeObserver(BeatObserver observer);
    void registerObserver(BPMObserver observer);
    void removeObserver(BPMObserver observer);
}
