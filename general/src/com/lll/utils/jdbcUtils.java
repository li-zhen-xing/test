package com.lll.utils;

import java.sql.*;

public class jdbcUtils {
    /**
     * 加载DB驱动
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection conn;
    public static Connection getConnection() throws SQLException {
        String url ="jdbc:mysql://localhost:3306/db_283";
        String user ="root";
        String password ="123";
        if (conn == null || conn.isClosed()){
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {

            if (conn !=null&&conn.isClosed()){
                conn.close();
            }if (stmt !=null&&stmt.isClosed()){
                stmt.close();
            }if (rs !=null&&rs.isClosed()){
                rs.close();
            }

    }
}
