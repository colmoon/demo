package com.moon.demo.service.annocation.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @classname: TestJsonSubTypes
 * @description: 测试多态
 * @author: wuxiaojian
 * @create: 2020-05-12 15:02
 */
public class TestJsonSubTypes {
    public static void main(String[] args) {
        version1Json2Test();
        version1Json1Test();
    }

    public static void version1Json2Test() {
        String json = "{\n" +
                "  \"id\": \"1\",\n" +
                "  \"type\": \"startEvent\",\n" +
                "  \"startEvent\": \"begin\",\n" +
                "  \"startInfo\": \"hello world\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            StartEvent startEvent = (StartEvent) mapper.readValue(json, BaseElement.class);
            System.out.println(startEvent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void version1Json1Test() {
        String jsonString = "[\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"type\": \"startEvent\",\n" +
                "    \"startEvent\": \"begin\",\n" +
                "    \"startInfo\": \"hello world\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"2\",\n" +
                "    \"type\": \"endEvent\",\n" +
                "    \"endEvent\": \"end\",\n" +
                "    \"endInfo\": \"hello jackson\"\n" +
                "  }\n" +
                "]";
        System.out.println(jsonString);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<BaseElement> baseElements;
            baseElements = objectMapper.readValue(jsonString,
                    new TypeReference<List<BaseElement>>() {
                    });
            baseElements.forEach(System.out::println);
            baseElements.forEach(baseElement -> {
                if (baseElement.getType().equalsIgnoreCase("startEvent")){
                    StartEvent startEvent = (StartEvent)baseElement;
                    System.out.println(startEvent.getStartEvent());
                    System.out.println(startEvent.getStartInfo());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
