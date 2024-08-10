package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.registerClick.RegisterClickRequest;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;

public interface RegisterClickUseCase {
    ShortenedURL execute(RegisterClickRequest request) throws ApplicationException;
}
