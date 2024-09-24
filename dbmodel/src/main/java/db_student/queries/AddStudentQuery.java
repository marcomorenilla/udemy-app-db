package db_student.queries;

import db_student.EntityHandler;
import db_student.Student;
import jakarta.persistence.EntityManager;

public class AddStudentQuery extends AbstractQuery {

    private EntityManager entityManager;

    public AddStudentQuery() {
        entityManager = EntityHandler.INSTANCE.getEntityManager();
    }

    public void addStudent(Student student) {
        open();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }


}
