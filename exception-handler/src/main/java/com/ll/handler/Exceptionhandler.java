package com.ll.handler;

import com.ll.exception.Ageexception;
import com.ll.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName Exceptionhandler
 * @Description
 * @Author 李振兴
 * @Date 2020/8/29 11:36
 **/
@ControllerAdvice
public class Exceptionhandler {

    @ExceptionHandler(value = Ageexception.class)
    public ModelAndView doAgeException(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","您的年龄不能大于80");
        mv.addObject("ex",ex);
        mv.setViewName("err");

        return mv;
    }
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","您的姓名错误");
        mv.addObject("ex",ex);
        mv.setViewName("err");
        return mv;
    }
}
