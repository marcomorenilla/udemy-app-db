package db_student;

import java.util.ArrayList;
import java.util.List;

public class RemoveStudentModel {
    private DB db;
    List<Student> students;

    public RemoveStudentModel() {
        db = DBHandler.INSTANCE.getInstance();
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        System.out.println("Requesting db list of students in the RemoveStudentModel class");
        return students = db.getStudents();

    }

    public void removeStudent(Student student) {
        System.out.printf("remove student in RemoveStudentModel: %s\n", student);
        db.removeStudent(student);
    }
}
