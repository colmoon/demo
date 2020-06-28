package com.goldcard.headfirstdesign.iteration;

import java.util.Iterator;

/**
 * @ClassName DinerMenu
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/15 19:43
 */
public class DinerMenu implements Menu{
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;

    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems > MAX_ITEMS){
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }

    }

    @Override
    public Iterator iterator() {
        return new DinnerMenuIterator(menuItems);
    }

    public class DinnerMenuIterator implements Iterator {
        MenuItem[] list;
        int position = 0;

        public DinnerMenuIterator(MenuItem[] list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            if (position >= list.length || list[position] == null){
                return  false;
            } else {
                return  true;
            }
        }

        @Override
        public Object next() {
            MenuItem menuItem = list[position];
            position++;
            return menuItem;
        }

        @Override
        public void remove() {
            if (position < 0){
                throw new IllegalStateException("You can't remove an item until you've done at least one next()");
            }
            if (list[position - 1] != null){
                for (int i = position - 1; i < (list.length - 1); i++) {
                    list[i] = list[i + 1];
                }
                list[list.length - 1] = null;
            }
        }
    }
}
