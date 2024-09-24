package dbservice;

import db_student.RemoveStudentModel;
import db_student.Student;
import db_student.queries.RemoveStudentQuery;
import java.util.List;
import service_interfaces.RemoveStudentService;

public class RemoveStudentImpl implements RemoveStudentService {
    private RemoveStudentQuery removeStudentModel;

    public RemoveStudentImpl() {
        removeStudentModel = new RemoveStudentQuery();
    }

    public List<Student> getStudents() {
        return removeStudentModel.getStudents();
    }

    @Override
    public void removeStudent(Student student) {
       removeStudentModel.removeStudent(student);
    }
}
