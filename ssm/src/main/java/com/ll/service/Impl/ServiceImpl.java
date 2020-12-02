package com.ll.service.Impl;

import com.ll.dao.StudentDao;
import com.ll.domain.Student;
import com.ll.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ServiceImpl
 * @Description
 * @Author 李振兴
 * @Date 2020/8/30 1:51
 **/
@Service
public class ServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> findStudens() {
        return studentDao.selectStudents();
    }
}
