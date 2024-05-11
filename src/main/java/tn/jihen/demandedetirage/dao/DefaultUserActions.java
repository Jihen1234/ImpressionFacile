package tn.jihen.demandedetirage.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tn.jihen.demandedetirage.entity.Administrator;
import tn.jihen.demandedetirage.entity.Teacher;
import tn.jihen.demandedetirage.entity.PrintAgent;

public class DefaultUserActions {

    public static boolean login(String username, String password) {
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();
        // Query the User entity by username
        TypedQuery<Administrator> adminQuery = entityManager.createQuery(
                "SELECT u FROM Administrator u WHERE u.username = :username AND u.password = :password",
                Administrator.class);
        adminQuery.setParameter("username", username);
        adminQuery.setParameter("password", password);

        // Teacher login check
        TypedQuery<Teacher> teacherQuery = entityManager.createQuery(
                "SELECT u FROM Teacher u WHERE u.username = :username AND u.password = :password",
                Teacher.class);
        teacherQuery.setParameter("username", username);
        teacherQuery.setParameter("password", password);

        // PrintAgent login check
        TypedQuery<PrintAgent> printAgentQuery = entityManager.createQuery(
                "SELECT u FROM PrintAgent u WHERE u.username = :username AND u.password = :password",
                PrintAgent.class);
        printAgentQuery.setParameter("username", username);
        printAgentQuery.setParameter("password", password);

        try {
            // Check each query to see if the user exists
            Administrator admin = adminQuery.getSingleResult();
            if (admin != null) {
                return true; // User is an admin
            }

            Teacher teacher = teacherQuery.getSingleResult();
            if (teacher != null) {
                return true; // User is a teacher
            }

            PrintAgent printAgent = printAgentQuery.getSingleResult();
            if (printAgent != null) {
                return true; // User is a print agent
            }

            // No user found in any of the roles
            return false;
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
