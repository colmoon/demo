package com.anhen.typesafa;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * @classname: TestConfig
 * @description: testConfig
 * @author: wuxiaojian
 * @create: 2020-05-06 17:17
 */
public class TestConfig {
    public static void main(String[] args) {
        Config testConfig = ConfigFactory.parseResources("test.conf");
        String string = testConfig.getString("simple-lib.foo");
        System.out.println(string);
        int anInt = testConfig.getInt("simple-app.answer");
        System.out.println(anInt);
    }
}

