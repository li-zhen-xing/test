package com.ll.springboot_jsp_shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**通过代码来控制访问权限
 * @ClassName OrderController
 * @Description
 * @Author 李振兴
 * @Date 2020/11/9 9:34
 **/

@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping("save")
    //请求中同时具有某些角色
    @RequiresRoles("admin")
    public String save(){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("admin")){
            System.out.println("保存订单");
        }else {
            System.out.println("无权访问");
        }
        //代码方式
        return "redirect:/index.jsp";
    }
}
