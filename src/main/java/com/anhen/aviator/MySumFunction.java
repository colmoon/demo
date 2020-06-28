package com.anhen.aviator;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

public class MySumFunction extends AbstractFunction {

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject a, AviatorObject b, AviatorObject c) {
        Number numA = FunctionUtils.getNumberValue(a, env);
        Number numB = FunctionUtils.getNumberValue(b, env);
        Number numC = FunctionUtils.getNumberValue(c, env);

        long result = numA.longValue() + numB.longValue() + numC.longValue();
        return AviatorLong.valueOf(result);
    }

    /**
     * 获取函数名
     * */
    @Override
    public String getName() {
        return "mySum";
    }
}


