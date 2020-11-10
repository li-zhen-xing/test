package com.ll;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * @ClassName ll
 * @Description
 * @Author 李振兴
 * @Date 2020/11/6 14:20
 **/
public class TestAuthenticatro {
    public static void main(String[] args) {
        //1.创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        //2.给安全管理器设置realm
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));

        //3.把安全管理器对象注入到Security安全工具类
        SecurityUtils.setSecurityManager(securityManager);

        //4.通过工具类获取subject主体
        Subject subject = SecurityUtils.getSubject();

        //5。创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("xiaochen","123");

        try {
            System.out.println(subject.isAuthenticated());//认证状态
            subject.login(token);//用户认证
            System.out.println(subject.isAuthenticated());//认证状态
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("认证失败不存在该用户");
        }catch(IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }


    }
}
