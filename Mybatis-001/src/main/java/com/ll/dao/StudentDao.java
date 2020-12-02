package com.ll.dao;

import com.ll.domain.Student;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName StudentDao
 * @Description
 * @Author 李振兴
 * @Date 2020/7/30 19:45
 **/
public interface StudentDao {
    List<Student> selectStudents() throws IOException;

    int insertStudent(Student student) throws IOException;
}
