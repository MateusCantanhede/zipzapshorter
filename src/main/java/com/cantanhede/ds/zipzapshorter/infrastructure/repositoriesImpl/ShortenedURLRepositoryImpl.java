package com.cantanhede.ds.zipzapshorter.infrastructure.repositoriesImpl;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.ShortenedURLRepository;
import com.cantanhede.ds.zipzapshorter.infrastructure.dataSource.ShortenedURLDatasource;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.ShortenedURLEntity;
import com.cantanhede.ds.zipzapshorter.infrastructure.mappers.ShortenedURLMapper;
import com.cantanhede.ds.zipzapshorter.infrastructure.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ShortenedURLRepositoryImpl implements ShortenedURLRepository {

    private final ShortenedURLDatasource dataSource;

    @Autowired
    public ShortenedURLRepositoryImpl(ShortenedURLDatasource context) {
        this.dataSource = context;
    }

    @Override
    public void save(ShortenedURL shortenedURL) {
        ShortenedURLEntity shortenedURLEntity = ShortenedURLMapper.mapToEntity(shortenedURL);
        dataSource.save(shortenedURLEntity);
    }

    @Override
    public Optional<ShortenedURL> findByShortenedURL(String shortenedURL) {
        return dataSource.findByShortUrl(shortenedURL).map(ShortenedURLMapper::mapToDomain);
    }

    @Override
    public List<ShortenedURL> findAll() {
        return dataSource.findAll().stream()
                .map(ShortenedURLMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShortenedURL> findByUserId(Long userId) {
        return dataSource.findByUserId(userId)
                .stream()
                .map(ShortenedURLMapper::mapToDomain)
                .collect(Collectors.toList());
    }
}
