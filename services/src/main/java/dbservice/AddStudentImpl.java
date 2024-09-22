package dbservice;

import db_student.AddStudentModel;
import db_student.Student;
import service_interfaces.AddStudentService;

public class AddStudentImpl implements AddStudentService {

    private AddStudentModel addStudentModel;

    public AddStudentImpl() {
        addStudentModel = new AddStudentModel();
    }

    @Override
    public void addStudent(Student student) {
        addStudentModel.addStudent(student);
    }
}
