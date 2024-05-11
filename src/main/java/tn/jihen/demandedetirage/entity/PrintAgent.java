package tn.jihen.demandedetirage.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PrintAgent extends User {
    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    // Constructors, getters, and setters
}
