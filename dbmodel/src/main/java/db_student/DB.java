package db_student;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private List<Student> students;

    public DB() {
        students = new ArrayList<Student>();
        students.add(new Student(1,"Marco","Morenilla",25,"marcomorenilla@gmail.com"));
        students.add(new Student(1,"Marco","Morenilla",25,"marcomorenilla@gmail.com"));
        students.add(new Student(1,"Marco","Morenilla",25,"marcomorenilla@gmail.com"));
    }
    public  void addStudent(Student student) {
         students.add(student);
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
