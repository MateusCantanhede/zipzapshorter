package com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.CreateShortenedURL;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLMessageResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.ShortenedURLRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.CreateShortenedURLUseCase;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class CreateShortenedURLUseCaseImpl implements CreateShortenedURLUseCase {
    private final UserRepository userRepository;
    private final ShortenedURLRepository shortenedURLRepository;

    public CreateShortenedURLUseCaseImpl(UserRepository userRepository, ShortenedURLRepository shortenedURLRepository) {
        this.userRepository = userRepository;
        this.shortenedURLRepository = shortenedURLRepository;
    }

    public ShortenedURLMessageResponseDTO execute(CreateShortenedURLRequest request) throws ApplicationException {
        var user = userRepository.findById(request.userId()).orElseThrow(() -> new ApplicationException("User not found"));
        var shortUrl = generateShortUrl(request.originalUrl());
        var shortenedUrl = new ShortenedURL(request.originalUrl(),shortUrl,OffsetDateTime.now(), OffsetDateTime.now().plusMonths(1),user);
        shortenedURLRepository.save(shortenedUrl);
        return new ShortenedURLMessageResponseDTO("Shortened URL successfully generated");
    }

    private String generateShortUrl(String originalUrl) {
        // Implement your URL shortening logic here
        return String.valueOf(originalUrl.hashCode());
    }
}
