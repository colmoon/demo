package com.moon.demo.service.annocation.sql;
import lombok.Data;

/**
 * @Author wuxiaojian
 * @Description 数据库表Member对应实例类bean
 * @Date  2019/5/27 9:50
 * @Param
 * @return
 **/
@DBTable(name = "MEMBER")
@Data
public class Member {
    //主键ID
    @SQLString(name = "ID",value = 50, constraint = @Constraints(primaryKey = true))
    private String id;

    @SQLString(name = "NAME" , value = 30)
    private String name;

    @SQLInteger(name = "AGE")
    private int age;

    @SQLString(name = "DESCRIPTION" ,value = 150 , constraint = @Constraints(allowNull = true))
    private String description;//个人描述
}