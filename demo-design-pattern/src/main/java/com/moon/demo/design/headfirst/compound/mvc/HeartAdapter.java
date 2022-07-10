package com.moon.demo.design.headfirst.compound.mvc;

/**
 * @ClassName HeartAdapter
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/26 20:56
 */
public class HeartAdapter implements BeatModelInterface {
    HeartModelInterface heart;

    public HeartAdapter(HeartModelInterface heart) {
        this.heart = heart;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public void setBPM(int bpm) {

    }

    @Override
    public int getBPM() {
        return heart.getHeartRate();
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        heart.registerObserver(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        heart.removeObserver(observer);
    }

    @Override
    public void registerObserver(BPMObserver observer) {
        heart.registerObserver(observer);
    }

    @Override
    public void removeObserver(BPMObserver observer) {
        heart.removeObserver(observer);
    }
}
