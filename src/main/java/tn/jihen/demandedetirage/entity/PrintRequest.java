package tn.jihen.demandedetirage.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PrintRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public PrintAgent getPrintAgent() {
        return printAgent;
    }

    public void setPrintAgent(PrintAgent printAgent) {
        this.printAgent = printAgent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void setNumOfCopies(int numOfCopies) {
        this.numOfCopies = numOfCopies;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "print_agent_id")
    private PrintAgent printAgent;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private int numOfCopies;

    @Column
    private String documentPath;

    // Constructors, getters, and setters
}
