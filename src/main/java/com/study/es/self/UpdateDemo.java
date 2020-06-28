package com.study.es.self;

import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UpdateDemo
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/19 14:21
 * @Version 1.0
 **/

public class UpdateDemo {
    public static void main(String[] args) throws Exception{

        RestHighLevelClient restHighLevelClient = EsClientConfig.getInstance();

        UpdateRequest request = new UpdateRequest(
                "posts",
                "doc",
                "3");
//        Map<String, Object> parameters = singletonMap("count", 4);

//        Script inline = new Script(ScriptType.INLINE, "painless",
//                "ctx._source.count += params.count", parameters);
//        request.script(inline);

//        Script stored = new Script(
//                ScriptType.STORED, null, "increment-field", parameters);
//        request.script(stored);

        //When using updates with a partial document, the partial document will be merged with the existing document.
        //方式1
        /*UpdateRequest request = new UpdateRequest("posts", "doc", "1");
        String jsonString = "{" +
                "\"updated\":\"2017-01-01\"," +
                "\"reason\":\"daily update\"" +
                "}";
        request.doc(jsonString, XContentType.JSON);*/

        //方式2
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", "kate");
        jsonMap.put("age", "20");
        request.doc(jsonMap);
        /*UpdateRequest request = new UpdateRequest("posts", "doc", "1")
                .doc(jsonMap);*/

        //Upsert
        //If the document does not already exist, it is possible to define some content that will be inserted as a new document using the upsert method:

        /*String jsonString = "{\"created\":\"2017-01-01\"}";
        request.upsert(jsonString, XContentType.JSON);*/

        /*Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("id", "3");
        jsonMap.put("name", "jack");
        jsonMap.put("age", "16");
        jsonMap.put("count", 3);
        request.upsert(jsonMap).doc(jsonMap);*/

        request.timeout(TimeValue.timeValueSeconds(1));
        request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);

        UpdateResponse updateResponse = restHighLevelClient.update(
                request, RequestOptions.DEFAULT);

        String index = updateResponse.getIndex();
        String type = updateResponse.getType();
        String id = updateResponse.getId();
        long version = updateResponse.getVersion();
        if (updateResponse.getResult() == DocWriteResponse.Result.CREATED) {

        } else if (updateResponse.getResult() == DocWriteResponse.Result.UPDATED) {

        } else if (updateResponse.getResult() == DocWriteResponse.Result.DELETED) {

        } else if (updateResponse.getResult() == DocWriteResponse.Result.NOOP) {

        }
    }
}
