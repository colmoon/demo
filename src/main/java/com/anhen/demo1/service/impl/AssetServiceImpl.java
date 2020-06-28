package com.anhen.demo1.service.impl;

import com.anhen.demo1.mapper.AssetMapper;
import com.anhen.demo1.mapper.BaseMapper;
import com.anhen.demo1.model.Asset;
import com.anhen.demo1.model.Page;
import com.anhen.demo1.service.AbstractBaseService;
import com.anhen.demo1.service.AssetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AssetServiceImpl
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/7/10 17:08
 * @Version 1.0
 **/
@Service
public class AssetServiceImpl extends AbstractBaseService<Integer, Asset> implements AssetService{

    @Resource
    AssetMapper assetMapper;

    @Override
    public BaseMapper<Integer, Asset> getMapper() {
        return assetMapper;
    }

    @Override
    public List<Asset> pageList(Page page) {
        return assetMapper.pageList(page);
    }

    @Override
    public int count() {
        return assetMapper.count();
    }
}
