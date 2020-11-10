package com.ll;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @ClassName TestShiroMD5
 * @Description
 * @Author 李振兴
 * @Date 2020/11/7 15:05
 **/
public class TestShiroMD5 {
    public static void main(String[] args) {

        //使用MD5
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash.toHex());

        //使用md5加sault
        Md5Hash md5Hash1 = new Md5Hash("123", "X0*7ps");
        System.out.println(md5Hash1);

        //使用md5和soult加hash散列
        Md5Hash md5Hash2 = new Md5Hash("123", "X0*7ps", 1024);
        System.out.println(md5Hash2);
    }
}
