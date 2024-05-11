package tn.jihen.demandedetirage.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseUtils {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
    public EntityManager getManager(){
        return entityManager;
    }
    public DatabaseUtils() {
        // Initialize the EntityManagerFactory using the persistence unit name specified in persistence.xml
        entityManagerFactory = Persistence.createEntityManagerFactory("maktbaPU");
        // Create an EntityManager
        entityManager = entityManagerFactory.createEntityManager();
    }

}
