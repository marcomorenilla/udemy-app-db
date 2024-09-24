package db_student.queries;

import db_student.EntityHandler;
import db_student.Student;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MainFrameQuery extends AbstractQuery {

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();

        TypedQuery query = EntityHandler.INSTANCE.getEntityManager()
                .createQuery("Select s from Student s", Student.class);

        students = query.getResultList();

        return students;
    };

}
