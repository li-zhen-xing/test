package com.ll;

import com.ll.dao.StudentDao;
import com.ll.dao.impl.StudentDaoImpl;
import com.ll.domain.Student;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName MyApp
 * @Description
 * @Author 李振兴
 * @Date 2020/7/30 20:57
 **/
public class MyApp {
    public static void main(String[] args) throws IOException {
        StudentDao studentDao=new StudentDaoImpl();

        Student student=new Student();
        student.setId(1005);
        student.setName("刘备");
        student.setEmail("beibei@qq.com");
        student.setAge(17);
        int unm=studentDao.insertStudent(student);
        System.out.println("插入"+unm+"条");

        List<Student> studentList=studentDao.selectStudents();
        for (Student stu :studentList){
            System.out.println("查询的学生"+stu);
        }
    }
}
