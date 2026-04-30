package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String title;

    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double totalAmount;

    private Boolean archive = false;


    @OneToMany(mappedBy = "expense", fetch= FetchType.LAZY)
    private List<Item> items;
}
