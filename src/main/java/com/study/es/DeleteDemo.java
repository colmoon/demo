package com.study.es;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;

/**
 * @ClassName DeleteDemo
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/19 16:39
 * @Version 1.0
 **/

public class DeleteDemo {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient client = EsClientConfig.getInstance();

        DeleteRequest request = new DeleteRequest(
                "posts",
                "doc",
                "1");

//        request.routing("routing");

//        request.parent("parent");

        request.timeout(TimeValue.timeValueMinutes(2));
//        request.timeout("2m");

//        request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
//        request.setRefreshPolicy("wait_for");

//        request.version(2);

//        request.versionType(VersionType.EXTERNAL);

        //同步
        DeleteResponse deleteResponse = client.delete(
                request, RequestOptions.DEFAULT);

//        A typical listener for delete looks like:

        ActionListener<DeleteResponse> listener = new ActionListener<DeleteResponse>() {
            @Override
            public void onResponse(DeleteResponse deleteResponse) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        };

        client.deleteAsync(request, RequestOptions.DEFAULT, listener);

//        The returned DeleteResponse allows to retrieve information about the executed operation as follows:

        String index = deleteResponse.getIndex();
        String type = deleteResponse.getType();
        String id = deleteResponse.getId();
        long version = deleteResponse.getVersion();
        ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {

        }
        if (shardInfo.getFailed() > 0) {
            for (ReplicationResponse.ShardInfo.Failure failure :
                    shardInfo.getFailures()) {
                String reason = failure.reason();
            }
        }
        /*DeleteRequest request = new DeleteRequest("posts", "doc", "does_not_exist");
        DeleteResponse deleteResponse = client.delete(
                request, RequestOptions.DEFAULT);
        if (deleteResponse.getResult() == DocWriteResponse.Result.NOT_FOUND) {

        }

        try {
            DeleteResponse deleteResponse = client.delete(
                    new DeleteRequest("posts", "doc", "1").version(2),
                    RequestOptions.DEFAULT);
        } catch (ElasticsearchException exception) {
            if (exception.status() == RestStatus.CONFLICT) {

            }
        }*/

        client.close();

    }
}
