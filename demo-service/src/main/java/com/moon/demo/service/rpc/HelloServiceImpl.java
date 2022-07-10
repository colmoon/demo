package com.moon.demo.service.rpc;
public class HelloServiceImpl implements HelloService {  
  
    @Override
    public String hello(String name) {
        return "Hello " + name;  
    }

    @Override
    public int sum(int number1, int number2) {
        return number1 + number2;
    }
}