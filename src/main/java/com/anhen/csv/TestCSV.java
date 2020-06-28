package com.anhen.csv;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName TestCSV
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/28 10:45
 * @Version 1.0
 **/

public class TestCSV {
    public static void main(String[] args){
        try {
//            testWrite();
//            testParse();
            testParse1();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void testWrite() throws Exception{
        FileOutputStream fos = new FileOutputStream("E:/abc.csv");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");

        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("序号", "检查范围", "检查内容");
        CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

        for (int i = 0; i < 10; i++) {
            csvPrinter.printRecord(i, "物理位置的选择", "物理位置XXX检查内容1");
        }

        csvPrinter.flush();
        csvPrinter.close();
    }

    public static void testParse() throws Exception {
        String[] header = {"序号", "检查范围", "检查内容"};
        FileInputStream fileInputStream = new FileInputStream("E:/abc.csv");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
        CSVParser parser = CSVFormat.EXCEL.withHeader(header).parse(inputStreamReader);
        for (CSVRecord record : parser.getRecords()) {
//            System.out.println(record);
            System.out.println(record.get("序号") + ","
                    + record.get("检查范围") + ","
                    + record.get("检查内容"));
        }
        parser.close();
    }

    public static void testParse1() throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("alert","威胁告警");
        map.put("http","HTTP审计");
        map.put("dns","DNS审计");
        map.put("ftp","FTP审计");
        map.put("ftp_data","FTP文件传输");
        map.put("tftp","TFTP审计");
        map.put("smtp","SMTP审计");
        map.put("pop3","POP3审计");
        map.put("smb","SMB审计");
        map.put("krb5","KRB5审计");
        map.put("ssh","SSH审计");
        map.put("tls","TLS审计");
        map.put("ikev2","IKEV2审计");
        map.put("flow","流量会话");

        File f = new File("E:\\temp\\csv");
        File[] fs = f.listFiles();

        File filePath = new File("E:\\temp\\csv\\dataType.sql");

        try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(filePath);
                // 缓存流必须建立在一个存在的流的基础上
                PrintWriter pw = new PrintWriter(filePath);
        ) {
            int j = 1;
            for (File file : fs){
                String fileName = file.getName();
                String name = fileName.split("\\.")[0].split("-")[1];

                String[] header = {"标准字段字段","SURICATA原生字段","字段含义","样例","备注1","是否发送","备注2"};
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
                CSVParser parser = CSVFormat.EXCEL.withHeader(header).parse(inputStreamReader);
                int i = 0;
                for (CSVRecord record : parser.getRecords()) {
                    System.out.println(record.get("标准字段字段") + ","
                            + record.get("字段含义") + ","
                            + record.get("是否发送") + "," + name);
                    String sql = "insert into t_data_type values(null,?,?,?,?,?,null,null)";
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("INSERT INTO `t_data_type` (`id`, `name`, `define`, `type`, `enable`, `factory`, `create_time`, `update_time`) VALUES(").append("'").append(j++).append("'");
                    try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bigdata-web?characterEncoding=UTF-8&useSSL=false","root", "wxj123456");
                         // 根据sql语句创建PreparedStatement
                         PreparedStatement ps = c.prepareStatement(sql);
                    ) {
                        if (i == 0){
                            // 设置参数
                            ps.setString(1, name);
                            ps.setString(2, map.get(name));
                            ps.setString(3, "");
                            ps.setInt(4,1);
                            ps.setInt(5,1);
                            stringBuilder.append(",'").append(name).append("','").append(map.get(name)).append("',").append("''")
                                    .append(",").append("'1'").append(",").append("'1'");
                        } else {
                            // 设置参数
                            ps.setString(1, record.get("标准字段字段"));
                            ps.setString(2, record.get("字段含义"));
                            ps.setString(3, name);
                            stringBuilder.append(",'").append(record.get("标准字段字段")).append("','").append(record.get("字段含义")).append("','").append(name).append("'");
                            if ("true".equals(record.get("是否发送"))){
                                ps.setInt(4,1);
                                ps.setInt(5,1);
                                stringBuilder.append(",").append("'1'").append(",").append("'1'");
                            } else {
                                ps.setInt(4,0);
                                ps.setInt(5,0);
                                stringBuilder.append(",").append("'0'").append(",").append("'0'");
                            }
                        }
                        stringBuilder.append(",now(),now());");
                        pw.println(stringBuilder.toString());
                        i++;

                        // 执行
                        ps.execute();

                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                parser.close();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        /*String[] header = {"标准字段字段","SURICATA原生字段","字段含义","样例","备注1","是否发送","备注2"};
        FileInputStream fileInputStream = new FileInputStream("E:\\temp\\dns.csv");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
        CSVParser parser = CSVFormat.EXCEL.withHeader(header).parse(inputStreamReader);
        for (CSVRecord record : parser.getRecords()) {
            System.out.println(record.get("标准字段字段") + ","
                    + record.get("字段含义") + ","
                    + record.get("是否发送"));
            String sql = "insert into t_data_type values(null,?,?,?,?,?,null,null)";
            try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bigdata-web?characterEncoding=UTF-8&useSSL=false","root", "wxj123456");
                 // 根据sql语句创建PreparedStatement
                 PreparedStatement ps = c.prepareStatement(sql);
            ) {

                // 设置参数
                ps.setString(1, record.get("标准字段字段"));
                ps.setString(2, record.get("字段含义"));
                ps.setString(3, "dns");
                if ("true".equals(record.get("是否发送"))){
                    ps.setInt(4,1);
                    ps.setInt(5,1);
                } else {
                    ps.setInt(4,0);
                    ps.setInt(5,0);
                }
                // 执行
                ps.execute();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        parser.close();*/

    }
}
