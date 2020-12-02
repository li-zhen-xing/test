package com.ll;

import com.ll.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * h@ClassName TestMybatis
 * @Description
 * @Author 李振兴
 * @Date 2020/7/30 22:43
 **/
public class TestMybatis {
    public static void main(String[] args) throws IOException {
        //定义mybatis主配置文件的位置,从类路径的跟开始（target/classes）
        String config ="mybatis.xml";
        //读取config表示的文件
        InputStream in= Resources.getResourceAsStream(config);
        //创建了SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //创建了SqlSessionFactory对象
        SqlSessionFactory factory =builder.build(in);
        //获取SqlSession对象，从SqlSessionFactory中获取
        SqlSession sqlSession=factory.openSession();
        //指定要执行的sql语句的标识，sql映射文件中的namespace+"."+标签的id值
        String sqlId="com.ll.dao.StudentDao"+"."+"insertStudent";
        Student student=new Student();
        student.setId(1002);
        student.setName("七七");
        student.setEmail("zhouzheng@qq.com");
        student.setAge(25);
        //执行sql语句，通过sqlId找到语句
        int nums=sqlSession.insert(sqlId,student);
        //mybatis默认不是自动提交事务的，所以在insert，update，delete后要手工提交事务
        sqlSession.commit();

            System.out.println("执行insert输出"+nums);

        //关闭SqlSession对象
        sqlSession.close();

    }
}
