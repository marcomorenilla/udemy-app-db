package dbservice;

import db_student.RemoveStudentModel;
import db_student.Student;
import java.util.List;
import service_interfaces.RemoveStudentService;

public class RemoveStudentImpl implements RemoveStudentService {
    private RemoveStudentModel removeStudentModel;

    public RemoveStudentImpl() {
        removeStudentModel = new RemoveStudentModel();
    }

    public List<Student> getStudents() {
        return removeStudentModel.getStudents();
    }

    @Override
    public void removeStudent(Student student) {
       removeStudentModel.removeStudent(student);
    }
}
