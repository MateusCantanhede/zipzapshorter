package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.Statistics;

public interface FindStatisticsByShortUrlIdUseCase {
    Statistics execute(String shortURL) throws ApplicationException;
}
