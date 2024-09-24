package db_student.queries;

import db_student.EntityHandler;
import db_student.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class RemoveStudentQuery extends AbstractQuery {

    private EntityManager entityManager;
    public RemoveStudentQuery() {
        entityManager = EntityHandler.INSTANCE.getEntityManager();
    }
   public List<Student> getStudents() {
       List<Student> students = new ArrayList<Student>();
       TypedQuery query = entityManager
               .createQuery("Select s from Student s", Student.class);

       students = query.getResultList();
       return students;
   }
    public void removeStudent(Student student) {
        open();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }
}
