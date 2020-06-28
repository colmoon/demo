package com.anhen.aviator;

import com.google.common.collect.ImmutableMap;
import com.googlecode.aviator.AviatorEvaluator;

import java.util.Map;

public class MySumFunctionTest {

    public static void main(String[] args) {
        // 注册函数
        AviatorEvaluator.addFunction(new MySumFunction());

        String expression = "mySum(x, y, z)";

        Map<String, Object> params = ImmutableMap.of("x", 1, "y", 2, "z", 3);

        long result = (long) AviatorEvaluator.execute(expression, params);

        System.out.print("result : " + result);

    }
}