package dao;

public class AddSQL {

    public String addSQL(String in,String info) {
        String sql = "INSERT INTO ";
        switch (in) {
            case "2.1":
                String student_id = info.split("\\.")[0];
                int id = Integer.parseInt(student_id);
                String student_name = info.split("\\.")[1];
                String student_age = info.split("\\.")[2];
                int age = Integer.parseInt(student_age);
                String student_sex = info.split("\\.")[3];
                System.out.println(sql+"student VALUES(" + id + "," +"'"+ student_name +"'"+ "," + age + "," +"'"+ student_sex +"' )");
                sql = sql + "student VALUES(" + id + "," +"'"+ student_name +"'"+ "," + age + "," +"'"+ student_sex +"' )";
                break;
            case "2.2":
                String subject_id = info.split("\\.")[0];
                String subject_name = info.split("\\.")[1];
                String subject_teacher = info.split("\\.")[2];
                sql = sql + "subject VALUES(" + subject_id + "," + subject_name + "," + subject_teacher + ")";
                break;
            case "2.3":
                String teacher_id = info.split("\\.")[0];
                String teacher_name = info.split("\\.")[1];
                String teacher_age = info.split("\\.")[2];
                String teacher_sex = info.split("\\.")[3];
                sql = sql + "teacher VALUES(" + teacher_id + "," + teacher_name + "," + teacher_age + "," + teacher_sex + ")";
                break;
            case "2.4":
                String stu_id = info.split("\\.")[0];
                String sub_name = info.split("\\.")[1];
                String score = info.split("\\.")[2];
                sql = sql + "score VALUES(" + stu_id + "," + sub_name + "," + score + ")";
                break;

        }
        return sql;
    }
}
