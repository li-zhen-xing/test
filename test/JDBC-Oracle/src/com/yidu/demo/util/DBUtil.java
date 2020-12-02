package com.yidu.demo.util;

/**
 * 类的描述：工具类
 *
 * @author 张珂
 * @version 1.0
 * @since 2020/07/15
 */


import java.sql.*;

/**
 * 类的描述：数据库的工具类
 */
public class DBUtil {
    /**
     * 驱动
     */
    private static final String driver="oracle.jdbc.OracleDriver";
    /**
     * 数据库的url
     */
    private static final String url="jdbc:oracle://localhost:oracle:thin:@127.0.0.1:1521:test283";
    /**
     * 用户
     */
    private static final String user="hr";
    /**
     * 密码
     */
    private static final String password="123456";

    static {
        try {
            //注册驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提供一个数据库连接对象并返回
     * @return 数据库连接对象
     *
     */
    public static Connection getConnection(){
        Connection connection  =  null;

        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放给定资源
     * @param connection  数据可以连接对象
     * @param statement SQL语句对象
     * @param resultSet 结果集对象
     */
    public static void closeAll(Connection connection , Statement statement , ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally {
                        if (connection != null) {
                            try {
                                connection.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
