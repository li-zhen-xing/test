package com.ll;

import com.ll.realm.customerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @ClassName TestCustomerRealmAuthenticator
 * @Description
 * @Author 李振兴
 * @Date 2020/11/6 16:47
 **/
public class TestCustomerRealmAuthenticator {
    public static void main(String[] args) {
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        //设置字定义realm
        defaultSecurityManager.setRealm(new customerRealm());
        //设置安全工具类
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //通过安全工具类获取subject
        Subject subject = SecurityUtils.getSubject();
        //创建token
        UsernamePasswordToken token=new UsernamePasswordToken("xiaochen","123");
        subject.login(token);
    }
}
