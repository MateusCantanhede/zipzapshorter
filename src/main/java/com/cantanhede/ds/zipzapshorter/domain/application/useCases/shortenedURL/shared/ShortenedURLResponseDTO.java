package com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import java.time.OffsetDateTime;

public record ShortenedURLResponseDTO(
        long id,
        String originalUrl,
        String shortUrl,
        OffsetDateTime creationDate,
        OffsetDateTime expirationDate,
        long userId
){
    // add métodos caso precise
}
