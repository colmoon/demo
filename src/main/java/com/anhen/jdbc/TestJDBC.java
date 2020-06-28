package com.anhen.jdbc;

import com.mysql.jdbc.NonRegisteringDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class TestJDBC {

    private static Logger logger = LoggerFactory.getLogger(TestJDBC.class);

    public static void main(String[] args) throws Exception {

        Connection connection = null;
        long tryTimes = 1;
        while (connection == null && tryTimes < 3) {
            try {
                logger.info("try {} times to connect to sphinx", tryTimes);
                Thread.sleep(500);
                Driver driver = new NonRegisteringDriver();
                connection = driver.connect("jdbc:mysql://" + "192.168.30.143" + ":" + 9306, null);
            } catch (SQLException | InterruptedException e) {
                logger.warn("connect to sphinx - {} error, error message : {}", 9306, e.getMessage());
                tryTimes += 1;
            }
        }


        try (Connection c = DriverManager.getConnection(
                "jdbc:mysql://192.168.30.143:9306?characterEncoding=utf8&maxAllowedPacket=512000",
                "", "");
             Statement s = c.createStatement();) {
 
            String sql = "select * from x1 limit 0,2";
//            String sql = "select * from category_";

            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int gid = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                System.out.printf("%d\t%d\t%s\t%s%n", id, gid, title, content);
                /*int id = rs.getInt("id");
                String content = rs.getString(2);
                System.out.printf("%d\t%s%n", id, content);*/
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}