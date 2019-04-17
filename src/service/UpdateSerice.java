package service;

import dao.Connect;
import dao.UpdateSQL;
import tools.Tools;

import java.sql.Connection;
import java.sql.Statement;

class UpdateSerice {
    UpdateSerice(String in) {
        switch (in) {
            case "3.1":
                System.out.println("请输入要修改的学生信息,例如，2.刘小.25.男");
                String info=Tools.getScanner();
                updateStudent(in,info);
                break;
        }
    }

    private void updateStudent(String in,String info) {
        Connect connect = new Connect();
        String sql = new UpdateSQL().updateSQL(in,info);
        Connection connection = connect.getConnect();
        Statement statement = connect.getStatement(connection);
        connect.executeSQL(statement, sql);
        System.out.println("修改学生信息成功");
    }
}
