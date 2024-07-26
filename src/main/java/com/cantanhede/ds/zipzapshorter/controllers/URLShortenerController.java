package com.cantanhede.ds.zipzapshorter.controllers;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.CreateShortenedURL.CreateShortenedURLRequest;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLMessageResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.CreateShortenedURLUseCase;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.GetUrlShortenerByShortenedURLUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
@Tag(name = "URL Shortener Controller", description = "Controller for URL shortening")
public class URLShortenerController {

    private final CreateShortenedURLUseCase createUrlShortenerUseCase;
    private final GetUrlShortenerByShortenedURLUseCase getUrlShortenerByShortenedURLUseCase;

    public URLShortenerController(CreateShortenedURLUseCase createUrlShortenerUseCase, GetUrlShortenerByShortenedURLUseCase getUrlShortenerByShortenedURLUseCase) {
        this.createUrlShortenerUseCase = createUrlShortenerUseCase;
        this.getUrlShortenerByShortenedURLUseCase = getUrlShortenerByShortenedURLUseCase;
    }

    @Operation(summary = "Get URLs by user ID", description = "Get all shortened URLs for a specific user")
    @GetMapping("/{shortURL}")
    public ResponseEntity<?> redirectToLongUrl(@PathVariable String shortURL) throws ApplicationException {
        var shortened = getUrlShortenerByShortenedURLUseCase.execute(shortURL);
        return ResponseEntity.status(302).location(URI.create(shortened.originalUrl())).build();
    }

    @Operation(summary = "Create a shortened URL", description = "Create a new shortened URL for a specific user")
    @PostMapping("/shorter")
    public ResponseEntity<ShortenedURLMessageResponseDTO> createShortenedURL(@RequestBody CreateShortenedURLRequest request) throws ApplicationException {
        var response = createUrlShortenerUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
