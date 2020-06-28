package com.goldcard.designPattern.builder;


import com.alibaba.fastjson.JSON;
import lombok.Getter;

/**
 * @Author wuxiaojian
 * @Description 建造者模式
 * @Date 2019/6/10 9:54
 * @Param
 * @return
 **/
@Getter
public class Person {
    private String name;
    private int age;
    private String location;
    private String job;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.location = builder.location;
        this.job = builder.job;
    }

    public static class Builder {
        private String name;
        private int age;
        private String location;
        private String job;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withJob(String job) {
            this.job = job;
            return this;
        }

        public Person builder() {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person person = new Person.Builder().withName("Bob").withAge(18).builder();
        System.out.println(JSON.toJSON(person));
    }

}
