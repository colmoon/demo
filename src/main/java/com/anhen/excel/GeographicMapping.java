package com.anhen.excel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName GeographicMapping
 * @Description 地理映射
 * @Author wuxiaojian
 * @Date 2019/10/22 9:51
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeographicMapping {
    private String ip;
    private String country;
    private String province;
    private String city;
    private String company;
}
