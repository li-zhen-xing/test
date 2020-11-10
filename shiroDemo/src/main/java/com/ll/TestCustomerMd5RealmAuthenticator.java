package com.ll;

import com.ll.realm.CustomerMd5Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * @ClassName TestCustomerMd5RealmAuthenticator
 * @Description
 * @Author 李振兴
 * @Date 2020/11/7 15:29
 **/
public class TestCustomerMd5RealmAuthenticator {
    public static void main(String[] args) {
        //创建安全管理器
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        //创建字定义realm
        CustomerMd5Realm realm = new CustomerMd5Realm();
        //设置realm的hash凭证匹配器
        HashedCredentialsMatcher credentialsMatcher =  new HashedCredentialsMatcher();
        //设置加密算法
        credentialsMatcher.setHashAlgorithmName("md5");
        //设置哈希散列
        credentialsMatcher.setHashIterations(1024);
        realm.setCredentialsMatcher(credentialsMatcher);
        //注入realm
        defaultSecurityManager.setRealm(realm);
        //将安全管理器注入到安全工具类
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //通过安全工具类获取subjectduixiang
        Subject subject = SecurityUtils.getSubject();
        //认证
        UsernamePasswordToken token=new UsernamePasswordToken("xiaochen","123");
        try {
            subject.login(token);
            System.out.println("登录成功");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }

        if(subject.isAuthenticated()){
            //是否具有一个角色
            System.out.println(subject.hasRole("admin"));
            //具有角色集合中的哪些角色
            boolean[] booleans = subject.hasRoles(Arrays.asList("admin", "user"));
            for (boolean b:booleans
                 ) {
                System.out.println(b);
            }
            //是否具有哪些角色的权限 资源标识符：操作：资源类型
            System.out.println(subject.isPermitted("user:updata:01"));
        }
    }

}
