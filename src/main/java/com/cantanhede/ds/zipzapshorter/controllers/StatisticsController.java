package com.cantanhede.ds.zipzapshorter.controllers;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.CreateShortenedURL.CreateShortenedURLRequest;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLMessageResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.registerClick.RegisterClickRequest;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.CreateShortenedURLUseCase;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.FindStatisticsByShortUrlIdUseCase;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.RegisterClickUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
@Tag(name = "URL Statistics Controller", description = "Controller for Statistics of the URL shortening")
public class StatisticsController {

    private final FindStatisticsByShortUrlIdUseCase findStatisticsByShortUrlIdUseCase;
    public StatisticsController(FindStatisticsByShortUrlIdUseCase findStatisticsByShortUrlIdUseCase) {
        this.findStatisticsByShortUrlIdUseCase = findStatisticsByShortUrlIdUseCase;
    }

    @Operation(summary = "Get Statistics by shortURL", description = "Get statistics for a specific shortURL")
    @GetMapping("/statistics/{shortURL}")
    public ResponseEntity<?> redirectToLongUrl(@PathVariable String shortURL) throws ApplicationException {
        var statistics = findStatisticsByShortUrlIdUseCase.execute(shortURL);
        return ResponseEntity.ok(statistics);
    }
}
