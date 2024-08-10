package com.cantanhede.ds.zipzapshorter.infrastructure.mappers;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.ShortenedURLEntity;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.UserEntity;

public class ShortenedURLMapper {
    public static ShortenedURLEntity mapToEntity(ShortenedURL shortenedURL) {
        return new ShortenedURLEntity(shortenedURL.getId(),shortenedURL.getOriginalUrl(),shortenedURL.getShortUrl(),shortenedURL.getCreationDate(),shortenedURL.getExpirationDate(),UserMapper.mapToEntity(shortenedURL.getUser()));
    }

    public static ShortenedURL mapToDomain(ShortenedURLEntity shortenedURLEntity) {
        return new ShortenedURL(shortenedURLEntity.getId(),shortenedURLEntity.getOriginalUrl(),shortenedURLEntity.getShortUrl(),shortenedURLEntity.getCreationDate(),shortenedURLEntity.getExpirationDate(),UserMapper.mapToDomain(shortenedURLEntity.getUser()));
    }
}
