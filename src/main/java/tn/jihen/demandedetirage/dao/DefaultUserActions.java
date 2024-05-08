package tn.jihen.demandedetirage.dao;

import jakarta.persistence.EntityManager;

public class DefaultUserActions {
    public boolean login(String username, String password) {
        EntityManager entityManager = DatabaseUtils.getEntityManager();

// Begin a transaction
        entityManager.getTransaction().begin();

// Perform database operations
// e.g., persist, merge, remove, find

// Commit the transaction
        entityManager.getTransaction().commit();

// Close the EntityManager
        entityManager.close();
        return true;

    }
}
