package db_student;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;


public enum EntityHandler {

    INSTANCE;

    private EntityManagerFactory factory;
    private EntityManager em;
    private EntityTransaction transaction;

    private EntityHandler(){
        factory= Persistence.createEntityManagerFactory("studentmanager");
        em = factory.createEntityManager();
        transaction = em.getTransaction();
    }


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
        System.out.println("Closing EntityManager and Factory");
        em.close();
        factory.close();
    }
}
