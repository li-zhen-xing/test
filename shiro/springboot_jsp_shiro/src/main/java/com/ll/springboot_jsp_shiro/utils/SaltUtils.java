package com.ll.springboot_jsp_shiro.utils;

import java.util.Random;

/**
 * @ClassName SaltUtils
 * @Description
 * @Author 李振兴
 * @Date 2020/11/8 17:31
 **/
public class SaltUtils {
    public static String getSalt(int n){
        char[] chars="ABCDEFGHIJKLNMOPQRSTUVWXYZabcdefghijklnmopqrstuvwxyz0123456789*(&^%#)".toCharArray();
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < n; i++) {
            char c=chars[(new Random().nextInt(chars.length))];
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}
