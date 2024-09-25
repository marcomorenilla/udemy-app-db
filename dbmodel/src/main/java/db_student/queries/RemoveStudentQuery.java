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
        System.out.println("Constructing RemoveStudentQuery");
        entityManager = EntityHandler.INSTANCE.getEntityManager();
    }
   public List<Student> getStudents() {
       open();
       List<Student> students = new ArrayList<Student>();
       TypedQuery query = entityManager
               .createQuery("Select s from Student s", Student.class);

       students = query.getResultList();
       for(Student student : students){
           System.out.println("This is the list the query is returning");
           System.out.println(student);
       }
       return students;
   }
    public void removeStudent(Student student) {
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }
}
