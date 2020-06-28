package com.goldcard.charactor;


public class ADHero extends Hero{
 
    int moveSpeed=400; //移动速度
 
    public int getMoveSpeed(){
        return this.moveSpeed;
    }
     
    public int getMoveSpeed2(){
        return super.moveSpeed;
    }
     
    public static void main(String[] args) {
        ADHero h= new ADHero();
        System.out.println(h.name);
        System.out.println(h.getMoveSpeed());
        System.out.println(h.getMoveSpeed2());
         
    }
  
}