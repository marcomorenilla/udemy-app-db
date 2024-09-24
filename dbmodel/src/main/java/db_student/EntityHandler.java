package db_student;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;


public enum EntityHandler {

    INSTANCE;

    private EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("studentmanager");
    private EntityManager em = factory.createEntityManager();
    private EntityTransaction transaction = em.getTransaction();


    public void open() {
        if(!transaction.isActive())
            transaction.begin();
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }

    public void shutdown() {
        em.close();
        factory.close();
    }
}
