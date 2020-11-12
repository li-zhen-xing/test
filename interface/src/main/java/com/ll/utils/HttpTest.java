package com.ll.utils;

import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @ClassName HttpTest
 * @Description
 * @Author 李振兴
 * @Date 2020/11/12 13:54
 **/
public class HttpTest {
    public static String Http(String adress,String method,Map<String,String> map) throws Exception {
        //1.定义需要访问的地址
        URL url = new URL(adress);
        //2.连接url
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //3.设置请求的方式
        connection.setRequestMethod(method);
        //4.设置请求可携带参数
        connection.setDoOutput(true);
        //5.拼接请求参数
        StringBuilder params=new StringBuilder();
        if (map!=null&&map.size()!=0){
            for (Map.Entry<String,String> param:map.entrySet()) {
                params.append("&").append(param.getKey()).append("=").append(param.getValue());
            }
            //6.写入参数到连接中 去除第一个&符号
            connection.getOutputStream().write(params.substring(1).toString().getBytes("UTF-8"));
        }
        //7.发起请求
        connection.connect();
        //8.接受返回值
        InputStream inputStream = connection.getInputStream();
        return StreamUtils.copyToString(inputStream, Charset.forName("UTF-8") );

    }
}
