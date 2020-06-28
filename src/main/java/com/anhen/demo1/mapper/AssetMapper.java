package com.anhen.demo1.mapper;

import com.anhen.demo1.model.Asset;
import com.anhen.demo1.service.PageService;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName AssetMapper
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/7/10 17:10
 * @Version 1.0
 **/
@Mapper
public interface AssetMapper extends BaseMapper<Integer, Asset>, PageService< Integer, Asset> {
    //自定义的一些查询方法;
}
