package com.moon.demo.design.headfirst.template;

/**
 * @ClassName BeverageTestDrive
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/12 20:51
 */
public class BeverageTestDrive {
    public static void main(String[] args) {
        Tea tea = new Tea();
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();

        System.out.println("\nMaking tea...");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee..");
        coffeeWithHook.prepareRecipe();
    }
}
