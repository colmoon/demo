package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
    private String name;
    private Double score;
  
    public Student(String name, Double score) {
        this.name = name;
        this.score = score;
    }
  
    public String getName() {
        return name;
    }
  
    public Double getScore() {
        return score;
    }
  
    public void setName(String name) {
        this.name = name;
    }
  
    public void setScore(Double score) {
        this.score = score;
    }
  
    @Override
    public String toString() {
        return "{"
                + "\"name\":\"" + name + "\""
                + ", \"score\":\"" + score + "\""
                + "}";
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>(){
            {
                add(new Student("stu1",100.0));
                add(new Student("stu2",97.0));
                add(new Student("stu3",96.0));
                add(new Student("stu4",95.0));
            }
        };
        Collections.sort(studentList,Comparator.comparingDouble(Student::getScore));
        System.out.println(studentList);
    }

    public void testThread(){
        new Thread(()-> System.out.println("test")).start();
    }
}