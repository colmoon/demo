package com.anhen.demo1.mapper;

import com.anhen.demo1.model.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName PageMapper
 * @Description 分页持久化层，查询总记录
 * @Author wuxiaojian
 * @Date 2019/7/10 16:57
 * @Version 1.0
 **/

public interface PageMapper<K, T> {

    /**
     * @Description 分页查询
     * @Date  2019/7/10 17:03
     * @Param [page]
     * @return java.util.List<T>
     **/
    List<T> pageList(@Param("page") Page page);

    /**
     * @Description //查询总数
     * @Date  2019/7/10 17:04
     * @Param [k]
     * @return int
     **/
    int count(@Param("param") K k);
}
