package com.ll.controller;

import com.ll.domain.Student;
import com.ll.service.Impl.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName StudentController
 * @Description
 * @Author 李振兴
 * @Date 2020/8/30 1:53
 **/
@Controller
public class StudentController {
    @Resource
    private ServiceImpl stuservice;

    @RequestMapping("/find.do")
    @ResponseBody
    public List<Student> findstudens(){
        List<Student> studens = stuservice.findStudens();
        return studens;
    }

    @RequestMapping("/findpage.do")
    public String findpage(){
        return "showStudent";
    }

    @RequestMapping("/add.do")
    public ModelAndView addstuden(Student student){
        ModelAndView mv=new ModelAndView();
        String tips="注册失败";
        int nums=stuservice.addStudent(student);
        if (nums>0){
            tips="学生（"+student.getName()+"）注册成功";
        }
        mv.addObject("tips",tips);
        mv.setViewName("result");
        return mv;
    }
}
