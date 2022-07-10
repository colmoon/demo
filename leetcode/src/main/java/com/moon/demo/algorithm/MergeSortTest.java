package com.moon.demo.algorithm;

/**
 * @classname: MergeSortTest
 * @description: MergeSortTest
 * https://blog.csdn.net/m53931422/article/details/41788535
 * @author: wuxiaojian
 * @create: 2020-07-11 15:52
 */
public class MergeSortTest {

    public static void merge(int[] array, int left, int middle, int right){
        //声明一个临时数组，长度为要归并数组的长度
        int[] tmp = new int[right - left + 1];
        //记住左边数组第一个元素的下标
        int i = left;
        //记住右边数组第一个元素的下标
        int j = middle + 1;
        int k = 0;
        while(i <= middle && j <= right){
            //左边数组元素和右边数组元素比较，把小的元素赋给临时数组
            if(array[i] <= array[j]){
                tmp[k++] = array[i++];
            }
            else{
                tmp[k++] = array[j++];
            }
        }
        //把左边剩余的数组元素赋给临时数组
        while(i <= middle){
            tmp[k++] = array[i++];
        }
        //把右边剩余的数组元素赋给临时数组
        while(j <= right){
            tmp[k++] = array[j++];
        }
        //用临时数组元素覆盖原数组元素
        if (tmp.length >= 0) {
            System.arraycopy(tmp, 0, array, left, tmp.length);
        }
    }
    public static void mergeSort(int[] array, int left, int right){
        if (left < right){
            int middle = left + (right - left)/2;
            //递归调用
            mergeSort(array, left, middle);
            mergeSort(array,middle + 1, right);
            //归并排序数据元素
            merge(array, left, middle, right);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{5,2,4,7,1,3,2,6};
        System.out.println("原始数据： ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        mergeSort(array,0,array.length - 1);
        System.out.println("输出结果： ");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
