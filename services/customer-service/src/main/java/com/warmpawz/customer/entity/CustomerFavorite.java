package com.warmpawz.customer.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "customer_favorites",
        indexes = {
                @Index(name = "idx_fav_customer_id", columnList = "customer_id"),
                @Index(name = "idx_fav_type_id", columnList = "favorite_type, favorite_id")
        })
public class CustomerFavorite {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "favorite_type", nullable = false)
    private FavoriteType favoriteType;

    @Column(name = "favorite_id", nullable = false)
    private UUID favoriteId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    public enum FavoriteType {
        VENDOR,
        SERVICE,
        PRODUCT
    }
}