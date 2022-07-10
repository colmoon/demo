package com.moon.demo.design.design.chapter1.isp;

public class Searcher extends AbstractSearcher {
    public Searcher(IGoodBodyGirl goodBodyGirl) {
        super(goodBodyGirl);
    }

    //展示美女的信息
    public Searcher(IGreatTemperamentGirl greatTemperamentGirl) {
        super(greatTemperamentGirl);
    }

    //展示美女的信息
    public void show() {
        System.out.println("--------美女的信息如下： ---------------");
        //展示面容
        super.goodBodyGirl.goodLooking();
        //展示身材
        super.goodBodyGirl.niceFigure();
        //展示气质
        super.greatTemperamentGirl.greatTemperament();
    }
}