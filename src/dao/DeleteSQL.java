package dao;

import tools.Tools;

public class DeleteSQL {

    public String deleteSQL(String in) {
        String sql = "";
        switch (in) {
            case "4.1":
                sql = "DELETE FROM student WHERE id =" + Tools.getScanner();
                break;
            case "4.2":
                sql = "DELETE FROM subject WHERE id =" + Tools.getScanner();
                break;
            case "4.3":
                sql = "DELETE FROM teacher WHERE id = " + Tools.getScanner();
                break;
        }
        return sql;
    }
}
