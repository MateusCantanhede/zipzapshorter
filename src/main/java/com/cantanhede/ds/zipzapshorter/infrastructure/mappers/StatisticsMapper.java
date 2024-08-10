package com.cantanhede.ds.zipzapshorter.infrastructure.mappers;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.Statistics;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.StatisticsEntity;

public class StatisticsMapper {
    public static  StatisticsEntity mapToEntity(Statistics statistics) {
        return new StatisticsEntity(statistics.getId(),ShortenedURLMapper.mapToEntity(statistics.getShortUrl()), statistics.getTotalClicks(),statistics.getUniqueVisitors(),statistics.getIpClient(), statistics.getClicksByDate());
    }

    public static Statistics mapToDomain(StatisticsEntity statisticsEntity) {
        return new Statistics(statisticsEntity.getId(),ShortenedURLMapper.mapToDomain(statisticsEntity.getShortenedURL()), statisticsEntity.getTotalClicks(),statisticsEntity.getUniqueVisitors(),statisticsEntity.getIpClient(), statisticsEntity.getClicksByDate());
    }
}
