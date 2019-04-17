package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    private static final String URL = "jdbc:mysql://localhost:3306/student_examination?useSSL=false";
    private static final String NAME = "root";
    private static final String PASSWORD = "13876599050zs";


        public Connection getConnect() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("数据库驱动不存在！");
            }
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(URL, NAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println("数据库连接失败！");
            }
            return conn;
        }

        public Statement getStatement(Connection conn) {
            Statement statement = null;
            try {
                statement = conn.createStatement();
            } catch (SQLException e) {
                System.out.println("创建Statement失败！");
            }
            return statement;
        }


        public ResultSet executeSQL(Statement statement, String sql) {
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(sql);
            } catch (SQLException e) {
                System.out.println("SQL语句错误！");
            }
            return rs;
        }

        public void closeConnect(ResultSet resultSet, Statement statement, Connection connection) {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("关闭ResultSet异常!");
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("关闭Statement异常！");
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("关闭Connection异常！");
                }
            }
        }
    }