package com.lll.servlets;

import com.lll.beans.Student;
import com.lll.dao.StudentDaoImpl;
import com.lll.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerservlet",urlPatterns = {"/registerServlet"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1.获取表单参数
        String num = request.getParameter("num");
        String password = request.getParameter("password");
        String ageStr = request.getParameter("age");
        String name = request.getParameter("name");
        String scoreStr = request.getParameter("score");

        Integer age = Integer.valueOf(ageStr);
        Integer score = Integer.valueOf(scoreStr);

        if (num == null || "".equals(num.trim())){
            System.out.println("nihao");
            response.sendRedirect(request.getContextPath()+"/register.jsp");
            return;
        }

        //2.创建student对象
        Student student = new Student(num, name, age, score);
        student.setPassword(password);
        //3.创建service对象
        StudentServiceImpl service = new StudentServiceImpl();
        //4.调用service对象的SaveStudent()方法将对象写入DB
        Integer id=service.saveStudent(student);
        System.out.println("id="+id);
        //5.写入失败则跳转到注册页面，重新注册
        if (id ==null){
            response.sendRedirect(request.getContextPath()+"/register.jsp");
        }
        //6.写入成功则跳转到登录页面
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
