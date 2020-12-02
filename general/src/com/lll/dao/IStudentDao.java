package com.lll.dao;

import com.lll.beans.Student;

public interface IStudentDao {
    public Student selecStudentLogin(String num, String password);

    Integer insertStudent(Student student);
}
