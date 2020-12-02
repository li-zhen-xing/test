package com.ll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName controller
 * @Description
 * @Author 李振兴
 * @Date 2020/11/27 10:02
 **/
@Controller
public class controller {

    @RequestMapping("/updateBook")
    public String test01(@RequestParam("author")String author, Map<String,Object> model, HttpServletRequest request,
                         @ModelAttribute("haha")Book book){
        System.out.println("页面提交过来的图书信息："+book);
        System.out.println("来到控制器");
        return "success";
    }

    @ModelAttribute("haha")
    public void hahaMyModelAttribute(Map<String,Object> map){
        Book book = new Book("吴承恩","西游记", 99,10,98);
        map.put("book",book);
        System.out.println("modelattribute方法");
        System.out.println("modelAttribute方法。。。查询了图书并保存起来了");
    }
}
