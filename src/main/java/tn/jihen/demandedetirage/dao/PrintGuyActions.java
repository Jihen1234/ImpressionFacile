package tn.jihen.demandedetirage.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tn.jihen.demandedetirage.entity.PrintAgent;
import tn.jihen.demandedetirage.entity.PrintRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class PrintGuyActions  extends DefaultUserActions{
    public static boolean login(String username, String password) {
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();
        // Query the User entity by username
        TypedQuery<PrintAgent> adminQuery = entityManager.createQuery(
                "SELECT u FROM PrintAgent u WHERE u.username = :username AND u.password = :password",
                PrintAgent.class);
        adminQuery.setParameter("username", username);
        adminQuery.setParameter("password", password);

        try {
            // Check each query to see if the user exists
            PrintAgent admin = adminQuery.getSingleResult();
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

    public static List<PrintRequest> getTasksForToday() {
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        TypedQuery<PrintRequest> adminQuery = entityManager.createQuery(
                "SELECT u FROM PrintRequest u where u.dateTime BETWEEN :startOfDay AND :endOfDay",
                PrintRequest.class);
        adminQuery  .setParameter("startOfDay", startOfDay);
        adminQuery  .setParameter("endOfDay", endOfDay);

        return adminQuery.getResultList();

    }

    public static String getDocumentFromDB(String documentId) {
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();

        TypedQuery<PrintRequest> adminQuery = entityManager.createQuery(
                "SELECT u FROM PrintRequest u where u.id=:documentId ",
                PrintRequest.class);
        adminQuery.setParameter("documentId", documentId);
        return adminQuery.getSingleResult().getDocumentPath();
    }
}
