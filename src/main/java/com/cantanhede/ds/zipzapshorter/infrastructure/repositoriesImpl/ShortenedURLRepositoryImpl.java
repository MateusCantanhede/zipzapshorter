package com.cantanhede.ds.zipzapshorter.infrastructure.repositoriesImpl;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.ShortenedURLRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.infrastructure.dataSource.ShortenedURLJpaRepository;
import com.cantanhede.ds.zipzapshorter.infrastructure.dataSource.UserJpaRepository;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.ShortenedURLEntity;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.UserEntity;
import com.cantanhede.ds.zipzapshorter.infrastructure.mappers.ShortenedURLMapper;
import com.cantanhede.ds.zipzapshorter.infrastructure.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ShortenedURLRepositoryImpl implements ShortenedURLRepository {

    private  final ShortenedURLJpaRepository context;

    @Autowired
    public ShortenedURLRepositoryImpl(ShortenedURLJpaRepository context) {
        this.context = context;
    }

    @Override
    public void save(ShortenedURL shortenedURL) {
        ShortenedURLEntity shortenedURLEntity = ShortenedURLMapper.mapToEntity(shortenedURL);
        context.save(shortenedURLEntity);
    }

    @Override
    public Optional<ShortenedURL> findById(Long id) {
        return context.findById(id).map(ShortenedURLMapper::mapToDomain);
    }

    @Override
    public List<ShortenedURL> findAll() {
        return context.findAll().stream()
                .map(ShortenedURLMapper::mapToDomain)
                .collect(Collectors.toList());
    }
}
