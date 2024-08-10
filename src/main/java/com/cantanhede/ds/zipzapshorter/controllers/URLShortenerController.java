package com.cantanhede.ds.zipzapshorter.controllers;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.CreateShortenedURL.CreateShortenedURLRequest;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLMessageResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.registerClick.RegisterClickRequest;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.CreateShortenedURLUseCase;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.GetUrlShortenerByShortenedURLUseCase;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.RegisterClickUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
@Tag(name = "URL Shortener Controller", description = "Controller for URL shortening")
public class URLShortenerController {

    private final CreateShortenedURLUseCase createUrlShortenerUseCase;
    private final RegisterClickUseCase registerClickUseCase;
    public URLShortenerController(CreateShortenedURLUseCase createUrlShortenerUseCase, RegisterClickUseCase registerClickUseCase) {
        this.createUrlShortenerUseCase = createUrlShortenerUseCase;
        this.registerClickUseCase = registerClickUseCase;
    }

    @Operation(summary = "redirect to long url", description = "redirect to long url by short url")
    @GetMapping("/{shortURL}")
    public ResponseEntity<?> redirectToLongUrl(@PathVariable String shortURL, HttpServletRequest request) throws ApplicationException {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = request.getRemoteAddr();
        }
        var shortened = registerClickUseCase.execute(new RegisterClickRequest(shortURL,ipAddress));
        return ResponseEntity.status(302).location(URI.create(shortened.getOriginalUrl())).build();
    }

    @Operation(summary = "Create a shortened URL", description = "Create a new shortened URL for a specific user")
    @PostMapping("/shorter")
    public ResponseEntity<ShortenedURLMessageResponseDTO> createShortenedURL(@RequestBody CreateShortenedURLRequest request) throws ApplicationException {
        var response = createUrlShortenerUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
