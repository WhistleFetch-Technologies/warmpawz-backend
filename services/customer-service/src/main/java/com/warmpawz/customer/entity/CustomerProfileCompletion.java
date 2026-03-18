package com.warmpawz.customer.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "customer_profile_completion")
public class CustomerProfileCompletion {

    @Id
    private UUID customerId;

    private boolean basicInfoCompleted;
    private boolean addressCompleted;
    private boolean petProfileCompleted;
    private boolean preferencesCompleted;

    private boolean isProfileComplete;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

}