package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName JsonObjectTest
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/10 10:46
 * @Version 1.0
 **/

public class JsonObjectTest {
    public static void main(String[] args) {
        String s = "{\n" +
                "  \"errorCode\": 0,\n" +
                "  \"message\": \"OK\",\n" +
                "  \"message_en\": \"OK\",\n" +
                "  \"responseCode\": \"OK\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"value\": 6,\n" +
                "      \"key\": \"事业单位\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 6,\n" +
                "      \"key\": \"政党组织\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 6,\n" +
                "      \"key\": \"省市级单位\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 6,\n" +
                "      \"key\": \"部委级单位\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 6,\n" +
                "      \"key\": \"银行\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 5,\n" +
                "      \"key\": \"互联网金融\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 5,\n" +
                "      \"key\": \"游戏\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 5,\n" +
                "      \"key\": \"证券\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 4,\n" +
                "      \"key\": \"保险\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 4,\n" +
                "      \"key\": \"信托\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 4,\n" +
                "      \"key\": \"期货\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 3,\n" +
                "      \"key\": \"出行\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 3,\n" +
                "      \"key\": \"搜索\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 3,\n" +
                "      \"key\": \"旅游\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 3,\n" +
                "      \"key\": \"电商\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 3,\n" +
                "      \"key\": \"社交\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 3,\n" +
                "      \"key\": \"门户\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 2,\n" +
                "      \"key\": \"工业制造\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 2,\n" +
                "      \"key\": \"运营商\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 1,\n" +
                "      \"key\": \"公安\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 1,\n" +
                "      \"key\": \"军工\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 1,\n" +
                "      \"key\": \"发电集团\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 1,\n" +
                "      \"key\": \"电网\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"value\": 1,\n" +
                "      \"key\": \"石油化工\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(s);
        String string = jsonObject.getString("errorCode");
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        System.out.println(string);
        System.out.println(jsonArray.getJSONObject(0).get("key"));
        List<Map<String, Object>> result = new ArrayList<>();
        result = jsonArray.stream().map(object -> {
            Map<String, Object> map = new HashMap<>();
            map.put("name", ((JSONObject)object).get("key"));
            map.put("total", ((JSONObject)object).get("value"));
            return map;
        }).collect(Collectors.toList());
        System.out.println(result.size());
    }
}
