package db_student.queries;

import db_student.EntityHandler;
import jakarta.persistence.EntityManager;

public class AbstractQuery {

    public void open(){
        EntityHandler.INSTANCE.open();
    }
    public void close(){
        EntityHandler.INSTANCE.shutdown();
    }
}
