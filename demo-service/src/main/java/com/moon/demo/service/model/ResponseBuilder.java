package com.moon.demo.service.model;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName ResponseBuilder
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/28 14:43
 * @Version 1.0
 **/

public interface ResponseBuilder<T extends Response> extends Function<T,T> {
    ResponseBuilder<Response> BUILDER = response -> response == null? new Response():null;
    /*ResponseBuilder<Response> BUILDER = new ResponseBuilder<Response>() {
        @Override
        public Response apply(Response response) {
            return response == null ? new Response() : null;
        }
    };*/

    // 请求成功
    ResponseBuilder<Response> SUCCESS = BUILDER.code(0);
    ResponseBuilder<Response> INSERT_SUCCESS = SUCCESS.message("新增成功");
    ResponseBuilder<Response> DELETE_SUCCESS = SUCCESS.message("删除成功");
    ResponseBuilder<Response> QUERY_SUCCESS = SUCCESS.message("查询成功");
    ResponseBuilder<Response> UPDATE_SUCCESS = SUCCESS.message("修改成功");

    //请求失败
    ResponseBuilder<Response> ERROR = BUILDER.code(-1);
    ResponseBuilder<Response> INSERT_ERROR = ERROR.message("新增失败");
    ResponseBuilder<Response> DELETE_ERROR = ERROR.message("删除失败");
    ResponseBuilder<Response> QUERY_ERROR = ERROR.message("查询失败");
    ResponseBuilder<Response> UPDATE_ERROR = ERROR.message("修改失败");


    //消息码构建器
    default ResponseBuilder<T> code(int code){
        return andThen(r -> {
            r.setCode(code);
            return r;
        });
    }

    //消息信息构建器
    default ResponseBuilder<T> message(String message){
        return andThen(r -> {
           r.setMessage(message);
           return r;
        });
    }

    //消息数据构建器
    default ResponseBuilder<T> data(Object data){
        return andThen(r->{
            r.setData(data);
            return r;
        });
    }

    //分页记录数
    default ResponseBuilder<PageResponse> total(int total){
        return ((ResponseBuilder<PageResponse>)this).create(PageResponse::new).andThen(r -> {
            r.setTotal(total);
            return r;
        });
    }

    //构造器连接器
    default ResponseBuilder<T> andThen(ResponseBuilder<T> after){
        Objects.requireNonNull(after);
        return r -> after.apply(apply(r));
    }

    //启动构建
    default T build(Object data){
        T t = build();
        t.setData(data);
        return t;
    }

    //启动构建
    default T build(){
        return apply(null);
    }

    default <R extends T> ResponseBuilder<R> create(Supplier<R> supplier){
        return r ->  (R) apply(r == null ? supplier.get() : null);
    }
}
