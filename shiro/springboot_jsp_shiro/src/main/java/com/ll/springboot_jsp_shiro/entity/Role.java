package com.ll.springboot_jsp_shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Role
 * @Description
 * @Author 李振兴
 * @Date 2020/11/9 9:45
 **/

@Data
@Accessors
@AllArgsConstructor
@NoArgsConstructor
public class Role  implements Serializable {
    private String id;
    private String name;
    private List<Perms> perms;
}
