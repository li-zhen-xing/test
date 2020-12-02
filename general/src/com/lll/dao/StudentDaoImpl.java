package com.lll.dao;

import com.lll.beans.Student;
import com.lll.utils.jdbcUtils;

import java.sql.*;

public class StudentDaoImpl implements IStudentDao {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public Student selecStudentLogin(String num, String password) {
        Student student = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql="select * from student where num=? and password=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,num);
            ps.setString(2,password);
            rs=ps.executeQuery();
            if (rs.next()){
                student =new Student();
                student.setId(rs.getInt("id"));
                student.setNum(rs.getString("num"));
                student.setPassword(rs.getNString("password"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                jdbcUtils.close(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public Integer insertStudent(Student student) {
        Integer id=null;
        try {
            conn =jdbcUtils.getConnection();
            String sql="insert into student(num,password,name,age,score) values (?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,student.getNum());
            ps.setString(2,student.getPassword());
            ps.setString(3,student.getName());
            ps.setInt(4,student.getAge());
            ps.setDouble(5,student.getScore());
            ps.executeUpdate();
            sql="select @@identity newid";
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                id=rs.getInt("newid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                jdbcUtils.close(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }

}
