package com.ll.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName CustomerMd5Realm
 * @Description
 * @Author 李振兴
 * @Date 2020/11/7 15:28
 **/
public class CustomerMd5Realm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();

        //根据身份信息 用户名 获取当前用户的角色信息，以及权限信息 xiaochen admin user
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //添加角色
        simpleAuthorizationInfo.addRole("user");
        simpleAuthorizationInfo.addRole("admin");
        //将数据库中查询权限信息赋值某个权限对象
        simpleAuthorizationInfo.addStringPermission("user:*:*");
        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取身份信息
        Object principal = authenticationToken.getPrincipal();

        if ("xiaochen".equals(principal)){
            //参数 1.数据库里用户字段信息 参数2.md5+sault生成的加密字符串 参数3.注册时的随机盐 参数4.realm的名字
            return new SimpleAuthenticationInfo(principal,
                    "e4f9bf3e0c58f045e62c23c533fcf633",
                    ByteSource.Util.bytes("X0*7ps"),
                    this.getName());
        }
        return null;
    }
}
