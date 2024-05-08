package tn.jihen.demandedetirage.entity;

import jakarta.persistence.*;

@Entity
public class Administrator extends User {
    @Column(nullable = false)
    private String name;

    // Constructors, getters, and setters
}
