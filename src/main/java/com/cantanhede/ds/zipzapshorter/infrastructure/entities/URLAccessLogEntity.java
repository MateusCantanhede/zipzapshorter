package com.cantanhede.ds.zipzapshorter.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class URLAccessLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String shortUrlId;

    @Column(nullable = false)
    private OffsetDateTime accessDate;

    @Column(nullable = false)
    private String ipAddress;

    @Column(nullable = false)
    private String userAgent;
}
