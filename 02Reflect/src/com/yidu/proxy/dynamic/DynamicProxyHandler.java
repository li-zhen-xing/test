package com.yidu.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName DynamicProxyHandler
 * @Description
 * @Author 李振兴
 * @Date 2020/7/22 10:42
 **/
public class DynamicProxyHandler<T> implements InvocationHandler {

    /*
    * 被代理的对象
    * */
    private T targetobj;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //事前处理
        postRequest();
        //动态调用目标对象的业务方法 获得结果对象
        Object resultObj = method.invoke(targetobj, args);

        return null;
    }

    public DynamicProxyHandler(T targetobj) {
        this.targetobj = targetobj;
    }

    private void preRequest(){
        System.out.println("事前操作：权限管理、开启事物、申请资源等....");
    }

    private void postRequest(){
        System.out.println("事后操作:日志记录、结束事务、释放资源等....");
    }
}
