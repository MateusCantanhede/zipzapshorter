package com.cantanhede.ds.zipzapshorter.domain.core.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Map;
@Setter
@Getter
public class Statistics {
    private String shortUrlId;
    private int totalClicks;
    private int uniqueVisitors;
    private Map<OffsetDateTime, Long> clicksByDate;

    public Statistics(String shortUrlId, int totalClicks, int uniqueVisitors, Map<OffsetDateTime, Long> clicksByDate) {
        this.shortUrlId = shortUrlId;
        this.totalClicks = totalClicks;
        this.uniqueVisitors = uniqueVisitors;
        this.clicksByDate = clicksByDate;
    }
}
