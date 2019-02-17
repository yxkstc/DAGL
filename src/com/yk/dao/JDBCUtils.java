/*
封装驱动连接，未对配置文件，IO读写做封装
*/
package com.yk.dao;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public final class JDBCUtils {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    static {
        /**
         * 驱动注册
         */
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    private JDBCUtils() {
    }

    /**
     * 获取 Connetion
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException, IOException {
        Properties p = com.yk.business.SqlConfigure.getGetProperties( );
        String url = "jdbc:sqlserver://" + p.getProperty("IP") + ":" + p.getProperty("Port") + ";databaseName=" + p.getProperty("DataBase") + ";user=" + p.getProperty("Login") + ";password=" + p.getProperty("PassWord") + ";"; //sa身份连接
        return DriverManager.getConnection(url);
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void colseResource(Connection conn, Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConnection(conn);
    }

    /**
     * 释放连接 Connection
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close( );
            } catch (SQLException e) {
                e.printStackTrace( );
            }
        }
        //等待垃圾回收
        conn = null;
    }

    /**
     * 释放语句执行者 Statement
     *
     * @param st
     */
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close( );
            } catch (SQLException e) {
                e.printStackTrace( );
            }
        }
        //等待垃圾回收
        st = null;
    }

    /**
     * 释放结果集 ResultSet
     *
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close( );
            } catch (SQLException e) {
                e.printStackTrace( );
            }
        }
        //等待垃圾回收
        rs = null;
    }
}