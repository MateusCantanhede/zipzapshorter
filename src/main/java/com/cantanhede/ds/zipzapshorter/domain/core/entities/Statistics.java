package com.cantanhede.ds.zipzapshorter.domain.core.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Map;
@Setter
@Getter
public class Statistics {
    private Long Id;
    private ShortenedURL shortUrl;
    private int totalClicks;
    private int uniqueVisitors;
    private String ipClient;
    private Map<OffsetDateTime, Long> clicksByDate;

    public Statistics(Long id, ShortenedURL shortUrl, int totalClicks,int uniqueVisitors, String ipClient, Map<OffsetDateTime, Long> clicksByDate) {
        this.Id = id;
        this.shortUrl = shortUrl;
        this.totalClicks = totalClicks;
        this.uniqueVisitors = uniqueVisitors;
        this.ipClient = ipClient;
        this.clicksByDate = clicksByDate;
    }
}
