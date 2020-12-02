package com.lll.service;

import com.lll.beans.Student;
import com.lll.dao.IStudentDao;
import com.lll.dao.StudentDaoImpl;

public class StudentServiceImpl implements IStudentService {
    private IStudentDao dao;

    public StudentServiceImpl() {
        dao =new StudentDaoImpl();
    }

    @Override
    public Student checkUser(String num, String password) {

        return dao.selecStudentLogin(num,password);
    }

    @Override
    public Integer saveStudent(Student student) {
        return dao.insertStudent(student);
    }
}
