package com.anhen.demo1.service;

import com.anhen.demo1.mapper.BaseMapper;
import com.anhen.demo1.service.BaseService;

import java.util.List;

/**
 * @ClassName AbstractBaseService
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/7/10 16:03
 * @Version 1.0
 **/

public abstract class AbstractBaseService<K, T> implements BaseService<K, T>{

    public abstract BaseMapper<K, T> getMapper();

    @Override
    public List list() {
        return getMapper().list();
    }

    @Override
    public T get(K k) {
        return getMapper().get(k);
    }

    @Override
    public int add(T t) {
        return getMapper().add(t);
    }

    @Override
    public int update(T t) {
        return getMapper().update(t);
    }

    @Override
    public int delete(K[] ids) {
        return getMapper().delete(ids);
    }
}
