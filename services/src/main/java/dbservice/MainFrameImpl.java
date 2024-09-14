package dbservice;

import db_student.DB;
import db_student.Student;

import java.util.List;

public class MainFrameImpl implements MainFrameService{
    private DB dataBase;

    public MainFrameImpl() {
        dataBase = new DB();
    }
    @Override
    public List<Student> getStudents() {
        return dataBase.getStudents();
    }
}
