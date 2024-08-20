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

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserEntity user; // Change from userId to UserEntity
}
