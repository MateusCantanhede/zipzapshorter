package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.CreateShortenedURL.CreateShortenedURLRequest;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;

import java.util.List;

public interface GetUrlShortenerByUserIdUsecase {
    List<ShortenedURL> execute(long userId);
}
