package com.moon.demo.design.headfirst.iteration;

import java.util.Calendar;
import java.util.Iterator;

/**
 * @ClassName AlternatingDinnerMenuIterator
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/15 21:29
 */
public class AlternatingDinnerMenuIterator implements Iterator {
    MenuItem[] items;
    int position;

    public AlternatingDinnerMenuIterator(MenuItem[] items) {
        this.items = items;
        Calendar rightNow = Calendar.getInstance();
        position = rightNow.get(Calendar.DAY_OF_WEEK) % 2;
    }

    @Override
    public boolean hasNext() {
        if (position > items.length || items[position] == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = items[position];
        position = position + 2;
        return menuItem;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("not supported");
    }

}
