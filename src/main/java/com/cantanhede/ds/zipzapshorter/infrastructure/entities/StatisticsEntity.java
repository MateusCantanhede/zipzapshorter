package com.cantanhede.ds.zipzapshorter.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StatisticsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "shortened_url_id")
    private ShortenedURLEntity shortenedURL;

    @Column(nullable = false)
    private int totalClicks;

    @Column(nullable = false)
    private int uniqueVisitors;

    @Column(nullable = false)
    private String ipClient;

    @ElementCollection
    @CollectionTable(name = "clicks_by_date", joinColumns = @JoinColumn(name = "statistics_id"))
    @MapKeyColumn(name = "date")
    @Column(name = "click_count")
    private Map<OffsetDateTime, Long> clicksByDate;
}
