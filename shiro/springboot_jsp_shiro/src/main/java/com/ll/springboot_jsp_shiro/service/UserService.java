package com.ll.springboot_jsp_shiro.service;

import com.ll.springboot_jsp_shiro.entity.Perms;
import com.ll.springboot_jsp_shiro.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description
 * @Author 李振兴
 * @Date 2020/11/8 17:25
 **/
public interface UserService {
    void register(User user);
    User findByUserName(String UserName);
    User findRolsByuserName(String userName);
    List<Perms> findPermsByuserName(String roleName);
}
