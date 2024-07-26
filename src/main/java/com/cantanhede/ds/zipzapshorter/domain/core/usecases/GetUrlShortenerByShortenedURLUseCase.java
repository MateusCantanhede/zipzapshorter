package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLResponseDTO;

public interface GetUrlShortenerByShortenedURLUseCase {
    ShortenedURLResponseDTO execute(String shortenedURL) throws ApplicationException;
}
