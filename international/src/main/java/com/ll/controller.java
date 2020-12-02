package com.ll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName controller
 * @Description
 * @Author 李振兴
 * @Date 2020/11/28 18:28
 **/

@Controller
public class controller {
    @RequestMapping("login")
    public String login(){
        return "login";
    }
}
