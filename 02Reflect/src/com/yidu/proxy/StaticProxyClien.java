package com.yidu.proxy;

import com.yidu.proxy.staticproxy.ProxySubject;
import com.yidu.proxy.staticproxy.Subject;

public class StaticProxyClien {
    public static void main(String[] args) {
        Subject subject=new ProxySubject();
        subject.request();
    }
}
