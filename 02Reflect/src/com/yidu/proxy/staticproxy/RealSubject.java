package com.yidu.proxy.staticproxy;

public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("真实主题角色来完成业务功能");
    }
}
