package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.CreateShortenedURL.CreateShortenedURLRequest;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;

public interface CreateShortenedURLUsecase {
    ShortenedURL execute(CreateShortenedURLRequest request);
}
