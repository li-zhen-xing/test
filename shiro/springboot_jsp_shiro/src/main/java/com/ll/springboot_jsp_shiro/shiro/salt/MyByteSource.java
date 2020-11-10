package com.ll.springboot_jsp_shiro.shiro.salt;

import org.apache.shiro.util.SimpleByteSource;

import java.io.Serializable;


/**
 * 字定义salt实现序列化接口  如果不实现序列化会报错，因为默认的simpleByteSource没有实现序列化接口且
 * 因为redis的template存储的是对象需要序列化，而使用缓存会存储这些授权认证信息都需要序列化才能存储
 * @ClassName SimpleByteSource
 * @Description
 * @Author 李振兴
 * @Date 2020/11/10 13:48
 **/

public class MyByteSource extends SimpleByteSource implements Serializable {

    public MyByteSource(String string) {
        super(string);
    }
}
