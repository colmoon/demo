package com.study.es;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @classname: IndexApiDemo
 * @description: IndexApiDemo
 * @author: wuxiaojian
 * @create: 2020-09-27 09:56
 */
@Slf4j
public class IndexApiDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = EsClientConfig.getInstance();
        IndexRequest request = new IndexRequest(
                "posts",
                "doc",
                "1");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
        try {
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            String index = indexResponse.getIndex();
            String type = indexResponse.getType();
            String id = indexResponse.getId();
            long version = indexResponse.getVersion();
        } catch (Exception e){
            log.error(e.getMessage(),e);
        }
        System.out.println();
    }
}
