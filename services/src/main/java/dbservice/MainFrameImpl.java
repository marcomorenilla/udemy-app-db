package dbservice;

import db_student.AddStudentModel;
import db_student.DBHandler;
import db_student.Student;

import java.util.List;
import service_interfaces.MainFrameService;

public class MainFrameImpl implements MainFrameService {
    private AddStudentModel addStudentModel;

    public MainFrameImpl() {
        addStudentModel = new AddStudentModel();
    }

    @Override
    public List<Student> getStudents() {
        return addStudentModel.getStudents();
    }
}
