package com.goldcard.callback;

/**
 * @ClassName CallBackA
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2019/1/28 16:52
 */
public class CallBackA {
    public static void main(String []args)
    {
        int a = 10452;
        int b = 423;
        //实例化计算器Calculator类
        CalculatorAs calculatorAs = new CalculatorAs(a,b);
        //调用计算器calculator的计算函数
        calculatorAs.calculation();
        //控制台输出
        System.out.println("/========================/");
    }
}


//计算的具体逻辑类
class LogicAs
{
    //计算的具体逻辑(计算方式)
    public void calculationLogic(int a, int b, CallBackInterface callBackInterface)
    {
        int result = a + b;
        //让线程等待5秒
        try
        {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //利用传进来的对象,回调计算结果.
        callBackInterface.calculationResult(a, b, result);
    }
}

//计算器类,实现了回调接口,用于本类的实例化对象传值
class CalculatorAs implements CallBackInterface
{
    private int a,b;

    public CalculatorAs(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public void calculation()
    {
        //开启另一个子线程
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                /*匿名实例化计算的具体逻辑类Logic,并调用计算函数.
                this是本类对象,因为实现了回调接口CallBackInterface,所以可以传值.*/
                new LogicAs().calculationLogic(a, b, CalculatorAs.this);
            }
        }).start();
    }

    //因为实现了回调接口CallBackInterface,必须要重写计算的结果回调函数calculationResult
    @Override
    public void calculationResult(int a, int b, int result)
    {
        //控制台输出
        System.out.println(a + " + " + b + " = " + result);
    }
}

