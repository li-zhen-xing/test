package com.ll.springboot_jsp_shiro.service;

import com.ll.springboot_jsp_shiro.dao.UserDao;
import com.ll.springboot_jsp_shiro.entity.Perms;
import com.ll.springboot_jsp_shiro.entity.User;
import com.ll.springboot_jsp_shiro.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author 李振兴
 * @Date 2020/11/8 17:26
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void register(User user) {
        //处理业务调用dao
        //对明文密码进行md5+salt+hash散列
        String salt = SaltUtils.getSalt(8);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassward(), salt, 1024);
        user.setPassward(md5Hash.toHex());
        userDao.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        User user = userDao.findByUserName(userName);
        return user;
    }

    @Override
    public User findRolsByuserName(String userName) {
        User user = userDao.findRolsByuserName(userName);
        return user;
    }

    @Override
    public List<Perms> findPermsByuserName(String roleName) {
        List list = userDao.findPermsByuserName(roleName);
        return list;
    }
}
