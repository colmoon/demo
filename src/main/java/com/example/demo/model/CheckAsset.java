package com.example.demo.model;

import lombok.Data;

@Data
public class CheckAsset {
    //资产id
    private Integer id;
    //项目id
    private Integer projectId;
    //资产名称
    private String name;
}
