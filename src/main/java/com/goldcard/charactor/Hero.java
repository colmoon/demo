package com.goldcard.charactor;
public class Hero {
        
    protected String name = "test"; //姓名
        
    float hp; //血量
        
    float armor; //护甲
        
    int moveSpeed = 200; //移动速度
     
    public Hero(){
        System.out.println("Hero的构造方法 ");
    }
     
    public static void main(String[] args) {
        new Hero();
    }
      
}