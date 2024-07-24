package com.cantanhede.ds.zipzapshorter.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShortenedURLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Use Long instead of long
    private String originalUrl;
    private String shortUrl;
    private OffsetDateTime creationDate;
    private OffsetDateTime expirationDate;

    public ShortenedURLEntity(OffsetDateTime expirationDate, OffsetDateTime creationDate, String shortUrl, String originalUrl) {
        this.expirationDate = expirationDate;
        this.creationDate = creationDate;
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
    }
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user; // Change from userId to UserEntity

    // TODO: adicionar regras de negocio do dominio
}
