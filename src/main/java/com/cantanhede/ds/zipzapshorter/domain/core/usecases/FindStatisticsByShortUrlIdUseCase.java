package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.shared.StatisticResponseDTO;

public interface FindStatisticsByShortUrlIdUseCase {
    StatisticResponseDTO execute(String shortURL) throws ApplicationException;
}
