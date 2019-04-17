package service;

import dao.Connect;
import dao.InquireSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class InquireService {
    InquireService(String in) throws SQLException {
        switch (in) {
            case "1.1.1":
                System.out.println("查询学生信息如下：");
                inquireStudent(in);
                break;
            case "1.1.2":
                System.out.println("请输入要查询的学生姓名（例如：刘昱涵）：");
                inquireScore(in);
                break;
            case "1.1.3":
                System.out.println("请输入要查询的老师（例如：张三）：");
                inquireScore(in);
                break;
            case "1.1.4":
                System.out.println("请输入要查询的课程（例如：语文）：");
                inquireScore(in);
                break;
            case "1.2.1":
                System.out.println("查询课程信息如下：");
                inquireSubject(in);
                break;
            case "1.2.2":
                System.out.println("请输入要查询的课程名称：（例如：语文）");
                inquireSubject(in);
                break;
            case "1.2.3":
                System.out.println("请输入要查询的老师（例如：张三）：");
                inquireSubject(in);
                break;
            case "1.3.1":
                System.out.println("查询所有老师信息为：");
                inquireTeacher(in);
                break;
            case "1.3.2":
                System.out.println("请输入要查询的老师（例如：张三）：");
                inquireTeacher(in);
                break;
        }
    }

    private void inquireStudent(String in) throws SQLException {
        Connect connect = new Connect();
        String sql = new InquireSQL().inquireSQL(in);
        Connection connection = connect.getConnect();
        Statement statement = connect.getStatement(connection);
        ResultSet resultSet = connect.executeSQL(statement, sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("student_name");
            int age = resultSet.getInt("student_age");
            String sex = resultSet.getString("student_sex");
            System.out.println("学号：" + id + "，名字:" + name + "，年龄：" + age + "，性别：" + sex);
        }
    }


    private void inquireScore(String in) throws SQLException {
        Connect connect = new Connect();
        String sql = new InquireSQL().inquireSQL(in);
        Connection connection = connect.getConnect();
        Statement statement = connect.getStatement(connection);
        ResultSet resultSet = connect.executeSQL(statement, sql);
        while (resultSet.next()) {
            String name = resultSet.getString("student_name");
            String subject = resultSet.getString("subject_name");
            Double score = resultSet.getDouble("score");
            System.out.println("名字：" + name + "，科目：" + subject + "，成绩：" + score);
        }
    }


    private void inquireSubject(String in) throws SQLException {
        Connect connect = new Connect();
        String sql = new InquireSQL().inquireSQL(in);
        Connection connection = connect.getConnect();
        Statement statement = connect.getStatement(connection);
        ResultSet resultSet = connect.executeSQL(statement, sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String subject = resultSet.getString("subject_name");
            String teacher_name = resultSet.getString("teacher_name");
            System.out.println("课程编号：" + id + "，名称：" + subject + "，老师：" + teacher_name);
        }
    }

    private void inquireTeacher(String in) throws SQLException {
        Connect connect = new Connect();
        String sql = new InquireSQL().inquireSQL(in);
        Connection connection = connect.getConnect();
        Statement statement = connect.getStatement(connection);
        ResultSet resultSet = connect.executeSQL(statement, sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("teacher_name");
            int age = resultSet.getInt("teacher_age");
            String sex = resultSet.getString("teacher_sex");
            System.out.println("老师编号：" + id + "，名字:" + name + "，年龄：" + age + "，性别：" + sex);
        }
    }
}


