package com.franchise.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "franchise_id", nullable = false)
    private Franchise franchise;
    
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Product> products;
}
