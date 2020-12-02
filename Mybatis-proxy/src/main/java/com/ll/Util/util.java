package com.ll.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName util
 * @Description
 * @Author 李振兴
 * @Date 2020/8/1 8:58
 **/
public class util {
    private static SqlSessionFactory factory=null;
    static {
        //定义mybatis主配置文件的位置,从类路径的跟开始（target/classes）
        String config ="mybatis.xml";

        try {
            //读取config表示的文件
            InputStream in = Resources.getResourceAsStream(config);
            //创建了SqlSessionFactory对象
            factory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession() {
        SqlSession sqlSession=null;
        if (factory!=null){
            sqlSession=factory.openSession();
        }
        return sqlSession;
    }
}
