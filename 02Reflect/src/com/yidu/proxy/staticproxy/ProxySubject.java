package com.yidu.proxy.staticproxy;

public class ProxySubject extends Subject {

    private Subject realSubject;
    @Override
    public void request() {
        preRequest();
        if (realSubject==null){
            realSubject=new RealSubject();
        }
        realSubject.request();
        postRequest();
    }
    private void preRequest(){
        System.out.println("事前操作：权限管理、开启事物、申请资源等....");
    }
    private void postRequest(){
        System.out.println("事后操作:日志记录、结束事务、释放资源等....");
    }
}
