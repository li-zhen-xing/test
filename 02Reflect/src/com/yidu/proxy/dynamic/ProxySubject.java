package com.yidu.proxy.dynamic;

/**
 * @ClassName ProxySubject
 * @Description
 * @Author 李振兴
 * @Date 2020/7/22 10:54
 **/
public class ProxySubject {
    public <T>T getProxyInstance(Class<T>requiredType){
        ClassLoader classLoader = requiredType.getClassLoader();
        Class<?>[] interfaces = requiredType.getInterfaces();
        
        return null;
    }
}
