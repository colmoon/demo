package com.anhen.demo1.model;

import lombok.Data;

/**
 * @ClassName Page
 * @Description 查询分页数，自动计算偏移量
 * @Author wuxiaojian
 * @Date 2019/7/10 16:28
 * @Version 1.0
 **/

@Data
public class Page {
    private int pageNo;
    private int pageSize;
    private int limit;
    private int offset;

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        updateOffset();
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.limit = pageSize;
        updateOffset();
    }

    private void updateOffset(){
        offset = pageSize == 0 ? 0 : (pageNo - 1) * pageSize;
    }
}
