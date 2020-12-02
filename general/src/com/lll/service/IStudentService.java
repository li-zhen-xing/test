package com.lll.service;

import com.lll.beans.Student;

public interface IStudentService {

    Student checkUser(String num, String password);

    Integer saveStudent(Student student);
}
