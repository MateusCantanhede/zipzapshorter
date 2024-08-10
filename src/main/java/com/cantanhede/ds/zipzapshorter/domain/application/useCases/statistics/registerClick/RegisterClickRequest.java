package com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.registerClick;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.Statistics;

import java.time.OffsetDateTime;
import java.util.Map;

public record RegisterClickRequest(
        String shortURL,
        String ipClient){
}
