package com.cantanhede.ds.zipzapshorter.domain.core.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class ShortenedURL {
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private OffsetDateTime creationDate;
    private OffsetDateTime expirationDate;
    private User user;

    public ShortenedURL(String originalUrl, String shortUrl, OffsetDateTime creationDate, OffsetDateTime expirationDate, User user) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.user = user;
    }
    public ShortenedURL(long id, String originalUrl, String shortUrl, OffsetDateTime creationDate, OffsetDateTime expirationDate, User user) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.user = user;
    }

    //TODO: adicionar regras de negocio do dominio
}
