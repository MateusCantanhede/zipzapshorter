package com.cantanhede.ds.zipzapshorter.domain.core.repositories;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.Statistics;
import java.util.List;
import java.util.Optional;

public interface StatisticsRepository {
    void save(Statistics statistics);
    Optional<Statistics> findByShortUrlId(Long shortUrlId);
    Optional<Statistics> findById(Long id);
    Optional<Statistics> findByIpClient(String ipClient);
    List<Statistics> findAll();
}
