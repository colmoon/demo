package com.anhen.shiro.introduction;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
 
public class TestEncryption {

    public static void main(String[] args) {
        simpleHash();
        md5Hash();
    }

    public static void simpleHash() {
        String password = "123";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
         
        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
         
        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ",password,salt,times,encodedPassword);
         
    }

    public static void md5Hash() {
        String password = "123";
        String encodedPassword = new Md5Hash(password).toString();

        System.out.println(encodedPassword);
    }


}