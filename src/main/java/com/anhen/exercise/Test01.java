package com.anhen.exercise;

/**
 * @ClassName Test01
 * @Description
 *  在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 *  每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 *  判断数组中是否含有该整数。
 * @Author wuxiaojian
 * @Date 2020/5/11 22:43
 * @Version 1.0
 **/

public class Test01 {
    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        int[][] array = {{}};
        int target = 15;
        boolean result = Find(target, array);
        System.out.println(result);
    }

    private static boolean Find(int target, int [][] array) {
        int row = 0;
        int column = array[0].length - 1;
        while (row < array.length && column >= 0){
            if (target == array[row][column]){
                return true;
            } else if (target > array[row][column]){
                row ++;
            } else {
                column --;
            }
        }
        return false;
    }
}

