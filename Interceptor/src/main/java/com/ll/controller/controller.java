package com.ll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName controller
 * @Description
 * @Author 李振兴
 * @Date 2020/8/29 14:32
 **/

@Controller
public class controller {

    @RequestMapping("/some.do")
    public ModelAndView dosome(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("hello");
        return mv;
    }
}
