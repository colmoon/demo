package com.moon.demo.design.design.chapter1.ocp;

public class OffNovelBook extends NovelBook {
    public OffNovelBook(String _name, int _price, String _author) {
        super(_name, _price, _author);
    }

    //覆写销售价格
    @Override
    public int getPrice() {
        //原价
        int selfPrice = super.getPrice();
        int offPrice = 0;
        if (selfPrice > 4000) { //原价大于40元， 则打9折
            offPrice = selfPrice * 90 / 100;
        } else {
            offPrice = selfPrice * 80 / 100;
        }
        return offPrice;
    }
}