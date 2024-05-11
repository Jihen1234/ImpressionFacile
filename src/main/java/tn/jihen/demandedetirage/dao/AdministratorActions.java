package tn.jihen.demandedetirage.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tn.jihen.demandedetirage.entity.Administrator;
import tn.jihen.demandedetirage.entity.PrintAgent;
import tn.jihen.demandedetirage.entity.PrintRequest;
import tn.jihen.demandedetirage.entity.Teacher;

import java.util.List;

public class AdministratorActions  extends DefaultUserActions{
    public static List<Teacher> GetTeachers(){
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();

        TypedQuery<Teacher> adminQuery = entityManager.createQuery(
                "SELECT u FROM Teacher u",
                Teacher.class);
        return adminQuery.getResultList();

    }
    public static List<PrintAgent> GetAgents(){
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();

        TypedQuery<PrintAgent> adminQuery = entityManager.createQuery(
                "SELECT u FROM PrintAgent u",
                PrintAgent.class);
        return adminQuery.getResultList();

    }

    public static boolean login(String username, String password) {
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();
        // Query the User entity by username
        TypedQuery<Administrator> adminQuery = entityManager.createQuery(
                "SELECT u FROM Administrator u WHERE u.username = :username AND u.password = :password",
                Administrator.class);
        adminQuery.setParameter("username", username);
        adminQuery.setParameter("password", password);

        try {
            // Check each query to see if the user exists
            Administrator admin = adminQuery.getSingleResult();
            return admin != null; // User is an admin
        } catch (Exception e) {
            // Handle exceptions (e.g., no user found or other errors)
            return false; // Return false if authentication fails
        } finally {
            // Close the entity manager if needed
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
