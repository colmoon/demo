package com.goldcard.headfirstdesign.compound.mvc;

/**
 * @ClassName DJTest
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/26 20:33
 */
public class DJTest {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
