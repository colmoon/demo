package com.moon.demo.design.headfirst.iteration;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @ClassName CafeMenu
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/15 21:03
 */
public class CafeMenu implements Menu {
    HashMap<String, MenuItem> menuItems = new HashMap<>();

    public CafeMenu(){
        addItem("Veggie Burger and Air Fries", "Veggie burger on whole wheat bun, lettuce, tomato, and fries", true, 3.99);
        addItem("Soup of the day", "A cup of the soup of the day, with a side sala", true, 3.69);
        addItem("Burrito","A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29);
    }

    public void addItem(String name, String description, boolean vegatarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegatarian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    @Override
    public Iterator iterator() {
        return menuItems.values().iterator();
    }
}
