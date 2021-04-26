package com.study.es;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SearchDemo
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/19 14:37
 * @Version 1.0
 **/

public class SearchDemoHit {
    public static void main(String[] args) throws Exception {
        SearchRequest searchRequest = new SearchRequest().indices(Constants.HIT_INTELLIGENCE_INDEX).types("intelligence");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("hit.isHit", true));
        sourceBuilder.from(0);
        sourceBuilder.size(10);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        RestHighLevelClient restHighLevelClient = EsClientConfig.getInstance();
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest.source(sourceBuilder));

        SearchHit[] searchHits = searchResponse.getHits().getHits();
        Map<String,Object> map = searchHits[0].getSourceAsMap();
        System.out.println(map.toString());

    }
}
