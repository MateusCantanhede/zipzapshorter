package com.cantanhede.ds.zipzapshorter.controllers;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.CreateShortenedURL.CreateShortenedURLRequest;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.CreateShortenedURLUsecase;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.GetUrlShortenerByUserIdUsecase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shorter")
@Tag(name = "URL Shortener Controller", description = "Controller for URL shortening")
public class URLShortenerController {

    private final CreateShortenedURLUsecase createUrlShortenerUsecase;
    private final GetUrlShortenerByUserIdUsecase getUrlShortenerByUserIdUsecase;

    public URLShortenerController(CreateShortenedURLUsecase createUrlShortenerUsecase, GetUrlShortenerByUserIdUsecase getUrlShortenerByUserIdUsecase) {
        this.createUrlShortenerUsecase = createUrlShortenerUsecase;
        this.getUrlShortenerByUserIdUsecase = getUrlShortenerByUserIdUsecase;
    }


    @Operation(summary = "Get URLs by user ID", description = "Get all shortened URLs for a specific user")
    @GetMapping("/users/{userId}/urls")
    public ResponseEntity<List<ShortenedURL>> getUrlsByUserId(@PathVariable long userId) {
        var response =  getUrlShortenerByUserIdUsecase.execute(userId);
        System.out.println("response controller:" + response.toString());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a shortened URL", description = "Create a new shortened URL for a specific user")
    @PostMapping("/urls")
    public ResponseEntity<ShortenedURL> createShortenedURL(@RequestBody CreateShortenedURLRequest request) {
        var response = createUrlShortenerUsecase.execute(request);
        return ResponseEntity.ok(response);
    }
}
