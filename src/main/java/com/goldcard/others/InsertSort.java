package com.goldcard.others;

/**
 * @ClassName InsertSort
 * @Description 插入排序
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/12/4 19:15
 */
public class InsertSort {
    public static void sort(int[] array){
        if (array == null || array.length == 0 || array.length == 1){
            return;
        }

        for (int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{1,8,5,6,7,0,0,0,0,2,1};
        sort(array);
        for (int i:array){
            System.out.print(i + " ");
        }
    }
}
