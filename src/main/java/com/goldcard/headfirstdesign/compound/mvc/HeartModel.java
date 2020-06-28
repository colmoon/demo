package com.goldcard.headfirstdesign.compound.mvc;


import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName HeartModel
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/26 21:07
 */
public class HeartModel implements HeartModelInterface,Runnable {
    ArrayList<BeatObserver> beatObservers = new ArrayList<>();
    ArrayList<BPMObserver> bpmObservers = new ArrayList<>();
    int time = 1000;
    int bpm = 90;
    Random random = new Random(System.currentTimeMillis());
    Thread thread;

    public HeartModel() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public int getHeartRate() {
        return 60000/time;
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        beatObservers.add(observer);
    }

    public void notifyBeatObservers(){
        for (int i = 0; i < beatObservers.size(); i++) {
            BeatObserver beatObserver = beatObservers.get(i);
            beatObserver.updateBeat();
        }
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        int i = beatObservers.indexOf(observer);
        if (i >= 0){
            beatObservers.remove(i);
        }
    }

    @Override
    public void registerObserver(BPMObserver observer) {
        bpmObservers.add(observer);
    }

    public void notifyBPMObservers(){
        for (BPMObserver observer: bpmObservers) {
            observer.updateBPM();
        }
    }

    @Override
    public void removeObserver(BPMObserver observer) {
        int i = bpmObservers.indexOf(observer);
        if (i >= 0){
            bpmObservers.remove(i);
        }
    }

    @Override
    public void run() {
        int lastrate = -1;
        while(true){
            int change = random.nextInt(10);
            if (random.nextInt(2) == 0){
                change = 0 - change;
            }
            int rate = 60000/(time + change);
            if (rate < 120 && rate > 50){
                time += change;
                notifyBeatObservers();
                if (rate != lastrate){
                    lastrate = rate;
                    notifyBPMObservers();
                }
            }
            try {
                Thread.sleep(time);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
