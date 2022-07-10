package com.moon.demo.service.annocation.sql;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TableCreator
 * @Description 运行时注解处理器，构造表创建语句 https://blog.csdn.net/javazejian/article/details/71860633
 * @Author wuxiaojian
 * @Date 2019/5/27 9:55
 * @Version 1.0
 **/

public class TableCreator {
    public static String createTableSql(String className) throws ClassNotFoundException{
        Class<?> cl = Class.forName(className);
        DBTable dbTable = cl.getAnnotation(DBTable.class);
        //如果没有表注解，直接返回
        if (dbTable == null){
            System.out.println("No DBTable annotations in class " + className);
            return null;
        }
        String tableName = dbTable.name();
        //If the name is empty, use the Class name;
        if (tableName.length() < 1){
            tableName = cl.getName().toUpperCase();
        }
        List<String> columnDefs = new ArrayList<>();
        //通过Class类API获取到所有成员字段
        for (Field field : cl.getDeclaredFields()) {
            String columnName = null;
            //获取字段上的注解
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length < 1) {
                continue; //Not a db table column
            }
            //判断注解类型
            if (annotations[0] instanceof SQLInteger) {
                SQLInteger sInt = (SQLInteger) annotations[0];
                //获取字段对应列名称，如果没有就是使用字段名称替代
                if (sInt.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sInt.name();
                }
                //构建语句
                columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
            }
            // 判断String类型
            if (annotations[0] instanceof SQLString) {
                SQLString sqlString = (SQLString) annotations[0];
                //Use field name if name not specified.
                if (sqlString.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sqlString.name();
                }
                columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")" + getConstraints(sqlString.constraint()));
            }
        }
        //数据库表构建语句
        StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
        for (String columnDef : columnDefs) {
            createCommand.append("\n  " + columnDef + ",");
        }
        //Remove trailing command
        String tableCreate = createCommand.substring(0,createCommand.length() - 1) + ");";
        return tableCreate;
    }
    /**
     * @Author wuxiaojian
     * @Description 判断该字段是否有其他约束
     * @Date  2019/5/27 10:25
     * @Param [con]
     * @return java.lang.String

     **/
    private static String getConstraints(Constraints con){
        StringBuilder constraints = new StringBuilder();
        if (!con.allowNull()){
            constraints.append(" NOT NULL");
        }
        if (con.primaryKey()){
            constraints.append(" PRIMARY KEY");
        }
        if (con.unique()){
            constraints.append(" UNIQUE");
        }
        return constraints.toString();
    }

    public static void main(String[] args) {
        try {
            String[] arg = {"com.anhen.annotation.demo1.Member"};
            for (String className:arg){
                System.out.println("Table Creation SQL for" + className + "is:\n" + createTableSql(className));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
