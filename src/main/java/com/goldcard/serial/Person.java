package com.goldcard.serial;

import java.io.Serializable;

public class Person implements Serializable{
   private static final long serialVersionUID = 1234567890L;
   private int id;
   private String name;
   public Person(int id, String name){
       this.id = id;
       this.name = name;
   }

   @Override
   public String toString(){
       return "Person: " + id + " " + name;
   }

}