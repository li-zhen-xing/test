package com.ll;

import com.ll.utils.HttpTest;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;


/**
 * @ClassName message
 * @Description
 * @Author 李振兴
 * @Date 2020/11/12 11:45
 **/
public class message {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("city","changsha");
        map.put("appkey","1edf494eef61d6e95ba8fa1939689714");
        String post = HttpTest.Http("https://way.jd.com/he/freeweather", "POST", map);
        System.out.println(post);

    }
}
