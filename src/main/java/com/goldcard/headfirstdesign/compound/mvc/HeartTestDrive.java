package com.goldcard.headfirstdesign.compound.mvc;

/**
 * @ClassName HeartTestDrive
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/26 21:05
 */
public class HeartTestDrive {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        ControllerInterface controller = new HeartController(heartModel);
    }
}
