package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLResponseDTO;

import java.util.List;

public interface GetUrlShortenerByUserIdUseCase {
    List<ShortenedURLResponseDTO> execute(long userId) throws ApplicationException;
}
