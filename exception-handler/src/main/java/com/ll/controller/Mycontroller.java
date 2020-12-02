package com.ll.controller;

/**
 * @ClassName Mycontroller
 * @Description
 * @Author 李振兴
 * @Date 2020/8/29 10:46
 **/


import com.ll.exception.Ageexception;
import com.ll.exception.MyuserException;
import com.ll.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Mycontroller {

    @RequestMapping("/some.do")
    public ModelAndView dosome(String name,Integer age) throws MyuserException {
        ModelAndView mv = new ModelAndView();

        if (!"zs".equals(name)){
            throw new NameException("姓名不对");
        }

        if (age==null||age>80){
            throw new Ageexception("年龄太大了");
        }
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }
}
