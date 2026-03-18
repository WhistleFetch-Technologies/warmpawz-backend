package com.warmpawz.customer.entity;

import com.warmpawz.customer.enums.OnboardingStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "customer_identity",
        indexes = {
                @Index(name = "idx_identity_phone", columnList = "phone")
        })
public class CustomerIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String phone;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "onboarding_status", nullable = false)
    private OnboardingStatus onboardingStatus = OnboardingStatus.INIT;

    @Column(name = "current_step")
    private String currentStep;

    @Column(columnDefinition = "jsonb")
    private Map<String, Object> metadata;

    @Column(name = "last_activity_at")
    private Instant lastActivityAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}