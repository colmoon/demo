package com.quartz.demo5.service;


import com.anhen.controller.model.PageResponse;
import com.anhen.controller.model.Response;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


/**
 * @ClassName ResponseBuilder
 * @Description 响应建造者，缓存，不可变，线程安全
 * @Author joker
 * @Date 2019/3/19 16:38
 * @Version 1.0
 **/
public interface ResponseBuilder<T extends Response> extends UnaryOperator<T> {
    ResponseBuilder<Response> BUILDER = r -> r == null ? new Response() : r;//初始构建器
    /**
     * 请求成功
     */
    ResponseBuilder<Response> SUCCESS = BUILDER.code(0);//请求成功
    ResponseBuilder<Response> DEFAULT_SUCCESS = SUCCESS.message("请求成功");//请求成功
    ResponseBuilder<Response> QUERY_SUCCESS = SUCCESS.message("查询成功");//查询成功
    ResponseBuilder<Response> INSERT_SUCCESS = SUCCESS.message("新增成功");//新增成功
    ResponseBuilder<Response> UPDATE_SUCCESS = SUCCESS.message("保存成功");//保存成功
    ResponseBuilder<Response> DELETE_SUCCESS = SUCCESS.message("删除成功");//删除成功
    ResponseBuilder<Response> EXPORT_SUCCESS = SUCCESS.message("导出成功");//导出成功
    ResponseBuilder<Response> IMPORT_SUCCESS = SUCCESS.message("导入成功");//导入成功
    /**
     * 警告信息
     */
    ResponseBuilder<Response> WARN = BUILDER.code(-100);//警告信息
    ResponseBuilder<Response> IMPORT_WARN = WARN.message("导入成功：%s");//部分导入成功
    /**
     * 请求request错误
     */
    ResponseBuilder<Response> NULL_PARAM = BUILDER.code(401).message("参数%s不能为空");//参数为空
    ResponseBuilder<Response> ALREADY_EXISTS = BUILDER.code(409).message("%s已存在");//唯一性校验
    /**
     * 服务端异常
     */
    ResponseBuilder<Response> SERVER_ERROR = BUILDER.code(500);//服务端异常
    ResponseBuilder<Response> DEFAULT_ERROR = SERVER_ERROR.message("服务端异常：%s");//服务端异常
    ResponseBuilder<Response> QUERY_ERROR = SERVER_ERROR.message("查询失败：%s");//查询异常
    ResponseBuilder<Response> INSERT_ERROR = SERVER_ERROR.message("新增失败：%s");//新增异常
    ResponseBuilder<Response> UPDATE_ERROR = SERVER_ERROR.message("保存失败：%s");//保存异常
    ResponseBuilder<Response> DELETE_ERROR = SERVER_ERROR.message("删除失败：%s");//删除异常
    ResponseBuilder<Response> EXPORT_ERROR = SERVER_ERROR.message("导出失败：%s");//导出失败
    ResponseBuilder<Response> IMPORT_ERROR = SERVER_ERROR.message("导入失败：%s");//导入失败

    /**
     * 消息码构建器，构建入口
     *
     * @param c
     * @return
     */
    default ResponseBuilder<T> code(int c) {
        return andThen(r -> {
            r.setCode(c);
            return r;
        });
    }

    /**
     * 消息信息构建器
     *
     * @param msg
     * @return
     */
    default ResponseBuilder<T> message(String msg) {
        return andThen(r -> {
            r.setMessage(msg);
            return r;
        });
    }

    /**
     * 格式化消息信息，使用string.format格式化
     *
     * @param msgs
     * @return
     */
    default ResponseBuilder<T> formatMsg(String... msgs) {
        return andThen(r -> {
            r.setMessage(String.format(r.getMessage(), msgs));
            return r;
        });
    }

    /**
     * 返回数据构建器
     *
     * @param data
     * @return
     */
    default ResponseBuilder<T> data(Object data) {
        return andThen(r -> {
            r.setData(data);
            return r;
        });
    }

    /**
     * 记录审计日志
     *
     * @return
     */
    default ResponseBuilder<T> opLog() {
        return andThen(r -> {
            //小于0为警告信息，审计记录为成功
            boolean result = r.getCode() <= 0;
            return r;
        });
    }

    /**
     * 记录审计日志
     *
     * @return
     */
    default ResponseBuilder<T> opLog(String msg) {
        return andThen(r -> {
            //小于0为警告信息，审计记录为成功
            boolean result = r.getCode() <= 0;
            return r;
        });
    }

    /**
     * 分页总记录数
     *
     * @param total
     * @return
     */
    default ResponseBuilder<PageResponse> total(int total) {
        return ((ResponseBuilder<PageResponse>) this).create(PageResponse::new)
                .andThen(r -> {
                    r.setTotal(total);
                    return r;
                });
    }

    /**
     * 构建器连接方法
     *
     * @param after
     * @return
     */
    default ResponseBuilder<T> andThen(ResponseBuilder<T> after) {
        Objects.requireNonNull(after);
        return r -> after.apply(apply(r));
    }

    /**
     * 启动构建
     *
     * @return
     */
    default T build(Object data) {
        T t = apply(null);
        t.setData(data);
        return t;
    }

    /**
     * 启动构建
     *
     * @return
     */
    default T build() {
        return apply(null);
    }

    /**
     * 自定义出事构建器
     *
     * @param creater
     * @return
     */
    default <R extends T> ResponseBuilder<R> create(Supplier<R> creater) {
        return r -> (R) apply((r == null ? creater.get() : r));
    }

}
