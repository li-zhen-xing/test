package com.ll.dao.impl;

import com.ll.Util.util;
import com.ll.dao.StudentDao;
import com.ll.domain.Student;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName StudentDaoImpl
 * @Description
 * @Author 李振兴
 * @Date 2020/8/1 8:39
 **/
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() throws IOException {
        util util=new util();
        SqlSession sqlSession=util.getSqlSession();
        //指定要执行的sql语句的标识，sql映射文件中的namespace+"."+标签的id值
        String sqlId="com.ll.dao.StudentDao"+"."+"selectStudent";
        //执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //关闭SqlSession对象
        sqlSession.close();

        return studentList;
    }

    @Override
    public int insertStudent(Student student) throws IOException {
        util util=new util();
        SqlSession sqlSession=util.getSqlSession();
        //指定要执行的sql语句的标识，sql映射文件中的namespace+"."+标签的id值
        String sqlId="com.ll.dao.StudentDao"+"."+"insertStudent";
        int nums=sqlSession.insert(sqlId,student);
        //mybatis默认不是自动提交事务的，所以在insert，update，delete后要手工提交事务
        sqlSession.commit();
        //关闭SqlSession对象
        sqlSession.close();
        return nums;
    }
}
