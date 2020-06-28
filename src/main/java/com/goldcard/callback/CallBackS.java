package com.goldcard.callback;

/**
 * @ClassName CallBackS
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2019/1/28 16:50
 */
public class CallBackS {
    public static void main(String []args)
    {
        int a = 10452;
        int b = 423;
        //实例化计算器Calculator类
        Calculator calculator = new Calculator(a,b);
        //调用计算器calculator的计算函数
        calculator.calculation();
        //控制台输出
        System.out.println("/========================/");
    }
}

//回调接口
interface CallBackInterface
{
    //计算的结果回调函数
    public void calculationResult(int a, int b, int result);
}

//计算的具体逻辑类
class Logic
{
    //计算的具体逻辑(计算方式)
    public void calculationLogic(int a, int b, CallBackInterface callBackInterface)
    {
        int result = a + b;
        //利用传进来的对象,回调计算结果.
        callBackInterface.calculationResult(a, b, result);
    }
}

//计算器类,实现了回调接口,用于本类的实例化对象传值
class Calculator implements CallBackInterface
{
    private int a,b;

    public Calculator(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public void calculation()
    {
        /*匿名实例化计算的具体逻辑类Logic,并调用计算函数.
        this是本类对象,因为实现了回调接口CallBackInterface,所以可以传值.*/
        new Logic().calculationLogic(a, b, this);
    }

    //因为实现了回调接口CallBackInterface,必须要重写计算的结果回调函数calculationResult
    @Override
    public void calculationResult(int a, int b, int result)
    {
        //控制台输出
        System.out.println(a + " + " + b + " = " + result);
    }
}
