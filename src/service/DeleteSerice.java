package service;

import dao.Connect;
import dao.DeleteSQL;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteSerice {
    DeleteSerice(String in){
        switch (in){
            case "4.1":
                System.out.println("请输入要删除的学生学号,例如：1");
                deleteStudent(in);
        }
    }
    private void deleteStudent(String in){
        Connect connect = new Connect();
        String sql = new DeleteSQL().deleteSQL(in);
        Connection connection = connect.getConnect();
        Statement statement = connect.getStatement(connection);
        connect.executeSQL(statement, sql);
    }
}
