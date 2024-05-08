package tn.jihen.demandedetirage.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PrintAgent extends User {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "printAgent")
    private List<PrintRequest> printRequests;

    // Constructors, getters, and setters
}
