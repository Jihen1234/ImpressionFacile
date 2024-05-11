package tn.jihen.demandedetirage.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PrintRequest {
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
