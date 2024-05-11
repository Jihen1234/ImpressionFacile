package tn.jihen.demandedetirage.dao;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import tn.jihen.demandedetirage.entity.PrintRequest;
import tn.jihen.demandedetirage.entity.Teacher;

public class TeacherActions extends DefaultUserActions{
    public static boolean login(String username, String password) {
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();
        // Query the User entity by username
        TypedQuery<Teacher> adminQuery = entityManager.createQuery(
                "SELECT u FROM Teacher u WHERE u.username = :username AND u.password = :password",
                Teacher.class);
        adminQuery.setParameter("username", username);
        adminQuery.setParameter("password", password);

        try {
            // Check each query to see if the user exists
            Teacher admin = adminQuery.getSingleResult();
            return admin != null; // User is an admin
        } catch (Exception e) {
            // Handle exceptions (e.g., no user found or other errors)
            throw e; // Return false if authentication fails
        } finally {
            // Close the entity manager if needed
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    public static List<Object[]> getTeachersSubjects(Long teacherId) {
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();
        // Query the User entity by username

        try {
            Query queryString = entityManager.createNativeQuery(
                    "SELECT subject,number_of_students FROM teacher_subjects u WHERE u.teacher_id = :teacher_id"
            );
            queryString.setParameter("teacher_id", teacherId);
            return queryString.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }


    public static Teacher getByUsername(String username) {
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();

        TypedQuery<Teacher> adminQuery = entityManager.createQuery(
                "SELECT u FROM Teacher u WHERE u.username = :username",
                Teacher.class);
        adminQuery.setParameter("username", username);
        try {
            return adminQuery.getSingleResult();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }


    }

    public static void addRequest(LocalDateTime arrivalDate, String filePath, int copies, String subject, Teacher teacherId) {

        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();
        entityManager.getTransaction().begin();
        PrintRequest pr = new PrintRequest();

        pr.setDateTime(arrivalDate);
        pr.setDocumentPath(filePath);
        pr.setNumOfCopies(copies);
        pr.setSubject(subject);
        pr.setTeacher(teacherId);
        entityManager.persist(pr);
        entityManager.getTransaction().commit();
    }

    public static int getSubject(String subject, Long id) {
        DatabaseUtils operations = new DatabaseUtils();
        EntityManager entityManager = operations.getManager();
        // Query the User entity by username

        try {
            Query queryString = entityManager.createNativeQuery(
                    "SELECT number_of_students FROM teacher_subjects u WHERE u.teacher_id = :teacher_id and u.subject= :subject"
            );
            queryString.setParameter("teacher_id", id);
            queryString.setParameter("subject", subject);
            return (int) queryString.getSingleResult();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

    }
}
