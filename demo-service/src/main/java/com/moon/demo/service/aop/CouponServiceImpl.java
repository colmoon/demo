package com.moon.demo.service.aop;

import org.springframework.stereotype.Service;

/**
 * @classname: CouponServiceImpl
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2024-01-10 18:41
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Override
    @Degrade(needDegrade = true)
    public void getCouponList() {

    }
}
