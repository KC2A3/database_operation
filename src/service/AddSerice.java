package service;

import dao.Connect;
import dao.AddSQL;
import tools.Tools;


import java.sql.Connection;
import java.sql.Statement;

class AddSerice {
    AddSerice(String in){
        switch (in) {
            case "2.1":
                System.out.println("请输入要增加的学生信息（例如：5.李四.20.女）");
                String info= Tools.getScanner();
                addStudent(in,info);
                break;
        }
    }

    private void addStudent(String in,String info) {
        Connect connect = new Connect();
        String sql = new AddSQL().addSQL(in,info);
        Connection connection = connect.getConnect();
        Statement statement = connect.getStatement(connection);
        connect.executeSQL(statement, sql);
        System.out.println("添加学生成功");
    }
}
