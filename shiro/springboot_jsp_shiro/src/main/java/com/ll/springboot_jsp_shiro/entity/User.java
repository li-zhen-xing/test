package com.ll.springboot_jsp_shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName User
 * @Description
 * @Author 李振兴
 * @Date 2020/11/8 17:11
 **/
@Data
@Accessors
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String id;
    private String username;
    private String passward;
    private String salt;
    private List<Role> roles;
}
