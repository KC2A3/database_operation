package dao;

import tools.Tools;

public class InquireSQL {
    public String inquireSQL(String in) {
        String sql = "SELECT * FROM score";

        switch (in) {
            case "1.1.1":
                sql = "SELECT * FROM student";
                break;
            case "1.1.2":
                sql = sql + " LEFT OUTER JOIN subject ON score.subject_id= subject.id" +
                        " LEFT OUTER JOIN student ON score.student_id = student.id" +
                        " right join teacher on teacher.id=subject.teacher_id WHERE student_name = '"
                        + Tools.getScanner() + "'";
                break;
            case "1.1.3":
                sql = sql + " LEFT OUTER JOIN subject ON score.subject_id= subject.id" +
                        " LEFT OUTER JOIN student ON score.student_id = student.id" +
                        " right join teacher on teacher.id=subject.teacher_id WHERE teacher_name = '"
                        + Tools.getScanner() + "'";
                break;
            case "1.1.4":
                sql = sql + " LEFT OUTER JOIN subject ON score.subject_id= subject.id" +
                        " LEFT OUTER JOIN student ON score.student_id = student.id" +
                        " right join teacher on teacher.id=subject.teacher_id WHERE subject_name = '"
                        + Tools.getScanner() + "'";
                break;
            case "1.2.1":
                sql = "SELECT * FROM subject " +
                        "LEFT OUTER JOIN teacher on teacher.id=subject.teacher_id";
                break;
            case "1.2.2":
                sql = "SELECT * FROM subject " +
                        "LEFT OUTER JOIN teacher on teacher.id=subject.teacher_id WHERE subject_name ='"
                        + Tools.getScanner() + "'";
                break;
            case "1.2.3":
                sql = "SELECT * FROM subject " +
                        "LEFT OUTER JOIN teacher on teacher.id=subject.teacher_id WHERE teacher_name='"
                        + Tools.getScanner() + "'";
                break;
            case "1.3.1":
                sql = "SELECT * FROM teacher";
                break;
            case "1.3.2":
                sql = "SELECT * FROM teacher WHERE teacher_name='"
                        + Tools.getScanner() + "'";
                ;
                break;
        }
        return sql;
    }
}
