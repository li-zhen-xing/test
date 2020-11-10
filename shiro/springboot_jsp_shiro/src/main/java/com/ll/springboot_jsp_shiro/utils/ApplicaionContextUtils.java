package com.ll.springboot_jsp_shiro.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName ApplicaionContextUtils
 * @Description
 * @Author 李振兴
 * @Date 2020/11/9 16:33
 **/
@Component
public class ApplicaionContextUtils implements ApplicationContextAware {

    private static   ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }

    public static Object getBean(String name){
        return context.getBean(name);
    }

}
