package com.moon.demo.algorithm.others;

import java.util.Scanner;

/**
 * @ClassName CommonDivisor
 * @Description 最大公约数，最小公倍数，辗转相除法
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/12/11 13:14
 */
public class CommonDivisor {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int m, n, temp;
        m = cin.nextInt();
        n = cin.nextInt();
        if(m < n){
            temp = m;
            m = n;
            n = temp;
        }
        int m1 = m, n1 = n;
        int r = 1;
        while (r != 0){
            r = m % n;
            m = n;
            n = r;
        }
        System.out.println(m);
        System.out.println(m1*n1/m);
    }
}
