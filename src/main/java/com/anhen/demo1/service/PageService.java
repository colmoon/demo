package com.anhen.demo1.service;

import com.anhen.demo1.model.Page;

import java.util.List;

/**
 * @ClassName PageService
 * @Description 分页service，查询总数
 * @Author wuxiaojian
 * @Date 2019/7/10 17:05
 * @Version 1.0
 **/

public interface PageService<K, T> {
    /**
     * @Description 分页查询
     * @Date  2019/7/10 17:03
     * @Param [page]
     * @return java.util.List<T>
     **/
    List<T> pageList(Page page);

    /**
     * @Description //查询总数
     * @Date  2019/7/10 17:04
     * @Param [k]
     * @return int
     **/
    int count();
}
