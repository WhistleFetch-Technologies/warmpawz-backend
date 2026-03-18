package com.warmpawz.customer.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "pet_breeds",
        indexes = {
                @Index(name = "idx_pet_breeds_species", columnList = "species")
        },
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"species", "name"})
        })
public class PetBreed {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 20)
    private String species; // keep string for flexibility

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "display_order")
    private Integer displayOrder = 0;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Column(name = "created_at")
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }
}