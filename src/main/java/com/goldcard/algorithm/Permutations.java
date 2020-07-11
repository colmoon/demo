package com.goldcard.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: Permutations
 * @description:
 * 题目描述：Given a collection of distinct integers, return all possible permutations.
 * （给定一组不同的整数，返回其所有的可能组合）
 *
 * 什么叫做回溯算法
 * （摘抄于百度百科）
 * 回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。
 * 回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，
 * 这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。许多复杂的，规模较大的问题都可以使用回溯法，有“通用解题方法”的美称。
 *
 * （摘抄于他人博客）
 * 在包含问题的所有解的解空间树中，按照深度优先搜索的策略，从根结点出发深度探索解空间树。当探索到某一结点时，要先判断该结点是否包含问题的解，
 * 如果包含，就从该结点出发继续探索下去，如果该结点不包含问题的解，则逐层向其祖先结点回溯。（其实回溯法就是对隐式图的深度优先搜索算法）。
 * 若用回溯法求问题的所有解时，要回溯到根，且根结点的所有可行的子树都要已被搜索遍才结束。 而若使用回溯法求任一个解时，只要搜索到问题的一个解就可以结束。
 *
 * 如何使用回溯算法
 * 回溯我认为也就是一种递归，有以下四个参数，当然不一定是我所举例的类型，要看题目而定
 * 一个全局变量集合保存所有满足条件的答案，举例：List<List> list
 *
 * 一个集合保存一个满足条件的答案，举例：List tempList
 *
 * 算法问题给所给的输入条件，这个可能是一个字符串，也可能是一个数组
 *
 * @author: wuxiaojian
 * @create: 2020-07-02 18:47
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        //一个全局变量，用于保存所有集合
        List<List<Integer>> list = new ArrayList<>();
        //传入三个参数，没有附加参数
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        //一个终结条件，也就是满足条件的时候
        if(tempList.size() == nums.length){
            //全局变量添加一个满足条件的集合
            list.add(new ArrayList<>(tempList));
        } else {
            //遍历所有情况
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) {
                    continue;
                }
                //如果tempList没有包含nums[i]才添加
                tempList.add(nums[i]);
                //递归调用，此时的tempList一直在变化，直到满足终结条件才结束
                backtrack(list, tempList, nums);
                System.out.println("tempList的内容:"+tempList+"-------"+"i的值:"+i);
                //它移除tempList最后一个元素的作用就是返回上一次调用时的数据，也就是希望返回之前的节点再去重新搜索满足条件。这样才能实现回溯
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        Permutations permutations = new Permutations();
        List<List<Integer>> permute = permutations.permute(nums);
        System.out.println(permute);
    }
}
