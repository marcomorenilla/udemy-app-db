package dbservice;

import db_student.Student;
import db_student.queries.AddStudentQuery;
import service_interfaces.AddStudentService;

public class AddStudentImpl implements AddStudentService {

    private AddStudentQuery addStudentModel;

    public AddStudentImpl() {
        addStudentModel = new AddStudentQuery();
    }

    @Override
    public void addStudent(Student student) {
        addStudentModel.addStudent(student);
    }
}
