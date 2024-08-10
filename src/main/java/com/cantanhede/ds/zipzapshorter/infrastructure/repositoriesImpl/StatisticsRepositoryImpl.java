package com.cantanhede.ds.zipzapshorter.infrastructure.repositoriesImpl;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.Statistics;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.StatisticsRepository;
import com.cantanhede.ds.zipzapshorter.infrastructure.dataSource.StatisticsJpaDatasource;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.StatisticsEntity;
import com.cantanhede.ds.zipzapshorter.infrastructure.mappers.StatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StatisticsRepositoryImpl implements StatisticsRepository {

    private final StatisticsJpaDatasource dataSource;

    @Autowired
    public StatisticsRepositoryImpl(StatisticsJpaDatasource context) {
        this.dataSource = context;
    }

    @Override
    public void save(Statistics statistics) {
        StatisticsEntity statisticsEntity = StatisticsMapper.mapToEntity(statistics);
        dataSource.save(statisticsEntity);
    }
    @Override
    public Optional<Statistics> findByShortUrlId(Long shortUrlId) {
        return dataSource.findByShortenedURLId(shortUrlId).map(StatisticsMapper::mapToDomain);
    }

    @Override
    public Optional<Statistics> findByIpClient(String ipClient) {
        return dataSource.findByIpClient(ipClient).map(StatisticsMapper::mapToDomain);
    }

    @Override
    public Optional<Statistics> findById(Long id) {
        return dataSource.findById(id).map(StatisticsMapper::mapToDomain);
    }

    @Override
    public List<Statistics> findAll() {
        return dataSource.findAll().stream()
                .map(StatisticsMapper::mapToDomain)
                .collect(Collectors.toList());
    }
}
