package dbservice;


import db_student.Student;
import db_student.queries.RemoveStudentQuery;
import java.util.List;
import service_interfaces.RemoveStudentService;

public class RemoveStudentImpl implements RemoveStudentService {
    private RemoveStudentQuery removeStudentQuery;

    public RemoveStudentImpl() {
        removeStudentQuery = new RemoveStudentQuery();
    }

    public List<Student> getStudents() {
        return removeStudentQuery.getStudents();
    }

    @Override
    public void removeStudent(Student student) {
       removeStudentQuery.removeStudent(student);
    }
}
