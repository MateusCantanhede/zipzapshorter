package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.registerClick.RegisterClickRequest;

public interface RegisterClickUseCase {
    ShortenedURLResponseDTO execute(RegisterClickRequest request) throws ApplicationException;
}
