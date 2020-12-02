package com.ll.service;

import com.ll.domain.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student>findStudens();
}
