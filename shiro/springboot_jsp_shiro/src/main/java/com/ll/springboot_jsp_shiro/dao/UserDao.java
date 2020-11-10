package com.ll.springboot_jsp_shiro.dao;

import com.ll.springboot_jsp_shiro.entity.Perms;
import com.ll.springboot_jsp_shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description
 * @Author 李振兴
 * @Date 2020/11/8 17:15
 **/
@Mapper
public interface UserDao {
    void save(User user);
    User findByUserName(String userName);
    User findRolsByuserName(String userName);
    List<Perms> findPermsByuserName(String roleName);
}
