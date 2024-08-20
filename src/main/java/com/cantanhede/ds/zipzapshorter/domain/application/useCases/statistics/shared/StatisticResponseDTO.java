package com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.shared;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;

import java.time.OffsetDateTime;
import java.util.Map;

public record StatisticResponseDTO(
        Long Id,
        ShortenedURL shortUrl,
        int totalClicks,
        int uniqueVisitors,
        String ipClient,
        Map<OffsetDateTime, Long>clicksByDate
){
    // add métodos caso precise
}
