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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalUrl;
    @Column(nullable = false, unique = true)
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
    @JoinColumn(nullable = false)
    private UserEntity user; // Change from userId to UserEntity

    // TODO: adicionar regras de negocio do dominio
}
