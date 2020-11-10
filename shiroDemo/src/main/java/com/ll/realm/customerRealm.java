package com.ll.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ClassName customerRealm 字定义realm
 * @Description
 * @Author 李振兴
 * @Date 2020/11/6 16:28
 **/
public class customerRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //在token中获取用户名
        String principal = (String) authenticationToken.getPrincipal();
        //根据身份信息使用jdbc mybatis查询相关数据库
        if ("xiaochen".equals(principal)){
            //参数一返回正确的用户名  参数二返货数据库中正确的密码  参数三提供当前realm的名字
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,"123",this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
