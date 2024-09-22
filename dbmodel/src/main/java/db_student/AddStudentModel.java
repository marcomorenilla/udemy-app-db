package db_student;

import java.util.ArrayList;
import java.util.List;

public class AddStudentModel {
    private DB db;
    List<Student> students;

    public AddStudentModel() {
        db = DBHandler.INSTANCE.getInstance();
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        System.out.println("Requesting db list of students in the AddStudentModel class");
        return students = db.getStudents();

    }

    public void addStudent(Student student) {
        System.out.printf("adding student in addStudentModel: %s\n", student);
        db.addStudent(student);
    }
}
