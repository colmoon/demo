package com.goldcard.callback.demo2;

/**
 * @ClassName A
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/7/9 15:10
 * @Version 1.0
 **/

public class A implements Callback{
    private Calculation calculation;

    public A(Calculation calculation){
        this.calculation = calculation;
    }

    private void ask(final String question){
        System.out.println("A give Calculation a question");
        new Thread(()->{
            calculation.executeMessage(this, question);
        }).start();
        play();
    }

    public void play(){
        System.out.println("I'am playing");
    }

    @Override
    public void solve(String result) {
        System.out.println("The result is " + result);
    }

    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        A a = new A(calculation);
        a.ask("1 + 1");
    }
}
