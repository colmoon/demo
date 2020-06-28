package com.anhen.demo1.service;

import java.util.List;

/**
 * @ClassName BaseService
 * @Description 基础增删查改服务
 * @Author wuxiaojian
 * @Date 2019/7/10 15:56
 * @Version 1.0
 **/

public interface BaseService<K, T> {

    /**
     * @Description 列表
     * @Param []
     * @return java.util.List<T>
     **/
    List<T> list();

    /**
     * @Author wuxiaojian
     * @Description 查询
     * @Date  2019/7/10 16:00
     * @Param [k]
     * @return T
     **/
    T get(K k);

    /**
     * @Author wuxiaojian
     * @Description 增加
     * @Date  2019/7/10 16:01
     * @Param [t]
     * @return int
     **/
    int add(T t);
    
    /**
     * @Author wuxiaojian
     * @Description 更新
     * @Date  2019/7/10 16:02
     * @Param [t]
     * @return int
     **/
    int update(T t);
    
    /**
     * @Author wuxiaojian
     * @Description 删除
     * @Date  2019/7/10 16:02
     * @Param [ids]
     * @return int
     **/
    int delete(K[] ids);
    
}
