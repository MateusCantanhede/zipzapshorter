package com.cantanhede.ds.zipzapshorter.infrastructure.mappers;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.ShortenedURLEntity;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.UserEntity;

public class ShortenedURLMapper {
    public static ShortenedURLEntity mapToEntity(ShortenedURL shortenedURL) {
        ShortenedURLEntity entity = new ShortenedURLEntity();
        entity.setId(shortenedURL.getId());
        entity.setOriginalUrl(shortenedURL.getOriginalUrl());
        entity.setShortUrl(shortenedURL.getShortUrl());
        entity.setCreationDate(shortenedURL.getCreationDate());
        entity.setExpirationDate(shortenedURL.getExpirationDate());
        entity.setUser(UserMapper.mapToEntity(shortenedURL.getUser()));
        return entity;
    }

    public static ShortenedURL mapToDomain(ShortenedURLEntity shortenedURLEntity) {
        return new ShortenedURL(shortenedURLEntity.getId(),shortenedURLEntity.getOriginalUrl(),shortenedURLEntity.getShortUrl(),shortenedURLEntity.getCreationDate(),shortenedURLEntity.getExpirationDate(),UserMapper.mapToDomain(shortenedURLEntity.getUser()));
    }
}
