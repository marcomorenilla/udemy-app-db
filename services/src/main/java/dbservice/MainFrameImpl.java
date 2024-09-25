package dbservice;

import db_student.AddStudentModel;
import db_student.DBHandler;
import db_student.Student;

import db_student.queries.AddStudentQuery;
import db_student.queries.MainFrameQuery;
import db_student.queries.RemoveStudentQuery;
import java.util.List;
import service_interfaces.MainFrameService;

public class MainFrameImpl implements MainFrameService {
    private MainFrameQuery mainFrameQuery;

    public MainFrameImpl() {
        mainFrameQuery = new MainFrameQuery();
    }

    @Override
    public List<Student> getStudents() {
        return mainFrameQuery.getStudents();
    }

    public void shutdown() {
        System.out.println("Shutting down from service");
        mainFrameQuery.close();
    }
}
