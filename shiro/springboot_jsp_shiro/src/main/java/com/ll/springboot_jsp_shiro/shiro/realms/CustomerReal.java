package com.ll.springboot_jsp_shiro.shiro.realms;

import com.ll.springboot_jsp_shiro.entity.Perms;
import com.ll.springboot_jsp_shiro.entity.Role;
import com.ll.springboot_jsp_shiro.entity.User;
import com.ll.springboot_jsp_shiro.service.UserService;
import com.ll.springboot_jsp_shiro.shiro.salt.MyByteSource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName CustomerReal
 * @Description
 * @Author 李振兴
 * @Date 2020/11/8 13:29
 **/
public class CustomerReal extends AuthorizingRealm {
    @Autowired
    UserService service;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前主对象用户名
        String principal = (String) principalCollection.getPrimaryPrincipal();
        //通过当前用户名获取角色集合
        User user = service.findRolsByuserName(principal);
        //遍历角色集合获得授权角色信息
        if (!CollectionUtils.isEmpty(user.getRoles())){
            List<Role> roles =user.getRoles();
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            roles.forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName());
                List<Perms> list = service.findPermsByuserName(role.getName());
                if (!CollectionUtils.isEmpty(list)){
                    list.forEach(l ->{
                            simpleAuthorizationInfo.addStringPermission(l.getName());
                    });
                }
            });
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        User user = service.findByUserName(principal);
        if (user!=null){
            //参数1.用户名 参数2.密码 参数3.随机盐 参数4.当前realm      使用自定义的ByteSource
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassward(),new MyByteSource(user.getSalt()),this.getName());
        }
        return null;
    }
}
