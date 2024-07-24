package com.cantanhede.ds.zipzapshorter.domain.core.repositories;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;

import java.util.List;
import java.util.Optional;

public interface ShortenedURLRepository {
    void save(ShortenedURL shortenedURL);
    Optional<ShortenedURL> findById(Long id);
    List<ShortenedURL> findAll();
}
