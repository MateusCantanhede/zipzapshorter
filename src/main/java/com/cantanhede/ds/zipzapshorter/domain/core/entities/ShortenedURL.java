package com.cantanhede.ds.zipzapshorter.domain.core.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class ShortenedURL {
    private long id;
    private String originalUrl;
    private String shortUrl;
    private OffsetDateTime creationDate;
    private OffsetDateTime expirationDate;
    private long userId;

    public ShortenedURL(long id, String originalUrl, String shortUrl, OffsetDateTime creationDate, OffsetDateTime expirationDate, long userId) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.userId = userId;
    }

    //TODO: adicionar regras de negocio do dominio
}
