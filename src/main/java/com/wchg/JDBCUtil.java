package com.wchg;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author 王朝刚
 * @date 2017/6/19 0:56
 */
public class JDBCUtil {

    /**
     * 不建议大家把配置硬编码到代码中
     * <p>
     * 最佳实践：配置型的建议写到配置文件。
     * <p>
     * 获取Connection
     *
     * @return 所获得到JDBC的Connection
     */
    public static Connection getConnection() throws Exception {
//        String url = "jdbc:mysql:///spring_data";
//        String user = "root";
//        String password = "123456";
//        String driverClass = "com.mysql.jdbc.Driver";

        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");


        Class.forName(driverClass);
        return DriverManager.getConnection(url, user, password);
    }


    /**
     * 释放掉资源
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
