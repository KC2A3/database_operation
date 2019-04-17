package service;

import dao.Connect;
import tools.Tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainService {
    public MainService() {
        getLogin();
    }

    private void getLogin() {
        Connect connect = new Connect();
        Connection connection = connect.getConnect();
        Statement statement = connect.getStatement(connection);
        System.out.println("您好，欢迎登陆学生考试系统，请输入您的用户名和密码(用户名:密码)：\n" +
                "例如：张三:123");
        String systemIn = Tools.getScanner();
        ResultSet resultSet = connect.executeSQL(statement, "SELECT * FROM administrator");
        String[] input = systemIn.split(":");
        try {
            while (resultSet.next()) {
                String user = resultSet.getString("name");
                String password = resultSet.getString("code");
                if (input[0].equals(user) && input[1].equals(password)) {
                    isLogin();
                } else {
                    System.out.println("————不能进入系统————\n" +
                            "\t账号或密码错误！\n" +
                            "\t请重新输入：");
                    getLogin();
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("————账号密码信息输入不全————\n" +
                    "\t请重新输入:");
            getLogin();
        } catch (SQLException e) {
            System.out.println("————进入SQL系统失败————\n" +
                    "\t请再次尝试：\n" + e.toString());
            getLogin();
        } finally {
            connect.closeConnect(resultSet, statement, connection);
        }
    }

    private void isLogin() throws SQLException {
        Tools.printMenu();
        select(Tools.getScanner());
    }

    private void select(String in) throws SQLException {
        String num = in.split("\\.")[0];
        switch (num) {
            case "1":
                new InquireService(in);
                isLogin();
                break;
            case "2":
                new AddSerice(in);
                isLogin();
                break;
            case "3":
                new UpdateSerice(in);
                isLogin();
                break;
            case "4":
                new DeleteSerice(in);
                isLogin();
                break;
            case "5":
                System.out.println("————退出系统————\n" +
                        "\t  欢迎下次使用！");
                break;
            default:
                System.out.println("————选项输入错误————\n" +
                        "\t请重新输入：\n");
                isLogin();
        }
    }
}
