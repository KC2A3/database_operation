package dao;

public class UpdateSQL {

    public String updateSQL(String in,String info) {
        String sql = "UPDATE ";
        switch (in) {
            case "3.1":
                String student_id = info.split("\\.")[0];
                String student_name = info.split("\\.")[1];
                String student_age = info.split("\\.")[2];
                String student_sex = info.split("\\.")[3];
                sql = sql + "student SET student_name=" + student_name + ",student_age=" + student_age + ",student_sex=" + student_sex + " WHERE id = " + student_id;
                break;
            case "3.2":
                String subject_id = info.split("\\.")[0];
                String subject_name = info.split("\\.")[1];
                String subject_teacher = info.split("\\.")[2];
                sql = sql + "subject SET subject_name=" + subject_name + ",teacher_id=" + subject_teacher + " WHERE id = " + subject_id;
                break;
            case "3.3":
                String teacher_id = info.split("\\.")[0];
                String teacher_name = info.split("\\.")[1];
                String teacher_age = info.split("\\.")[2];
                String teacher_sex = info.split("\\.")[3];
                sql = sql + "teacher SET teacher_name=" + teacher_name + ",teacher_age" + teacher_age + ",teacher_sex" + teacher_sex + " WHERE id = " + teacher_id;
                break;
            case "3.4":
                String stu_id = info.split("\\.")[0];
                String sub_name = info.split("\\.")[1];
                String score = info.split("\\.")[2];
                sql = sql + "score SET subject_id=" + sub_name + ",score=" + score + " WHERE student_id=" + stu_id;
                break;
        }
        return sql;
    }
}
