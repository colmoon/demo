package com.moon.demo.service.annocation.user;

/**
 * @ClassName User
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/9 13:16
 * @Version 1.0
 **/

public class User {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    @Init(value = "tom")
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    @Init(value = "22")
    public void setAge(String age) {
        this.age = age;
    }
}
