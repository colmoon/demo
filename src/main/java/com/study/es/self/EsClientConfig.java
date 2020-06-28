package com.study.es.self;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName EsClientConfig
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/19 14:27
 * @Version 1.0
 **/

@Configuration
public class EsClientConfig {

    private static class SingleTonHolder{
        private static RestHighLevelClient INSTANCE = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
    }

    /*
     * @Bean注解默认作用域为单例singleton作用域，可通过@Scope(“prototype”)设置为多例
     **/
    @Bean
    public RestHighLevelClient buildRestHighLevelClient(){
        return SingleTonHolder.INSTANCE;
    }

    public static RestHighLevelClient getInstance(){
        return SingleTonHolder.INSTANCE;
    }


}
