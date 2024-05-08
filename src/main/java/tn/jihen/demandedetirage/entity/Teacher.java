package tn.jihen.demandedetirage.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Teacher extends User {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "teacher")
    private List<PrintRequest> printRequests;

    @ElementCollection
    @CollectionTable(name = "teacher_subjects", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "subject")
    private List<String> subjects;

    // Constructors, getters, and setters
}
