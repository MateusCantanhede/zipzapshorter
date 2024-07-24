package com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.CreateShortenedURL;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.ShortenedURLRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.CreateShortenedURLUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class CreateShortenedURLUsecaseImpl implements CreateShortenedURLUsecase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShortenedURLRepository shortenedURLRepository;

    public ShortenedURL execute(CreateShortenedURLRequest request) {
        User user = userRepository.findById(request.userId()).orElseThrow(() -> new RuntimeException("User not found"));
        String shortUrl = generateShortUrl(request.originalUrl());
        ShortenedURL shortenedUrl = new ShortenedURL(request.originalUrl(),shortUrl,OffsetDateTime.now(), OffsetDateTime.now().plusMonths(1),user);
        shortenedURLRepository.save(shortenedUrl);
        return shortenedUrl;
    }

    private String generateShortUrl(String originalUrl) {
        // Implement your URL shortening logic here
        return "short.ly/" + originalUrl.hashCode();
    }
}
