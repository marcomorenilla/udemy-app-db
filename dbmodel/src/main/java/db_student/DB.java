package db_student;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private List<Student> students;

    public DB() {
        students = new ArrayList<Student>();
        students.add(new Student(1,"Marco","Morenilla",25,"marcomorenilla@gmail.com"));
        students.add(new Student(2,"Rigo","Uran",32,"rigouran@gmail.com"));
        System.out.println("Constructing DB with this list of students");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public  void addStudent(Student student) {
         students.add(student);
        System.out.println("DB method Student added"+student);
        System.out.println("Currently DB in DB method added");
        for (Student s: students) {
            System.out.println(s);
        }
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        System.out.println("I'm Db and here you have the list that I'm currently handling");
        for (Student student : students) {
            System.out.println("Student: " + student);
        }
        return students;
    }

    public void setStudents(List<Student> students) {
        System.out.println("I'm Db thanks for bringing a new list of students");
        this.students = students;
    }
}
