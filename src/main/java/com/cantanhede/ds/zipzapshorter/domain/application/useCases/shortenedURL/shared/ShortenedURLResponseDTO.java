package com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared;
import java.time.OffsetDateTime;

public record ShortenedURLResponseDTO(
        Long id,
        String originalUrl,
        String shortUrl,
        OffsetDateTime creationDate,
        OffsetDateTime expirationDate,
        Long userId
){
    // add métodos caso precise
}
