package com.cantanhede.ds.zipzapshorter.infrastructure.dataSource;

import com.cantanhede.ds.zipzapshorter.infrastructure.entities.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsJpaDatasource extends JpaRepository<StatisticsEntity, Long> {
    Optional<StatisticsEntity> findByIpClient(String ipClient);
    Optional<StatisticsEntity> findByShortenedURLId(Long shortUrlId);
}
