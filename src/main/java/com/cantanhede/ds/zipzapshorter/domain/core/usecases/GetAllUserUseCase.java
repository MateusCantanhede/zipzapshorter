package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared.UserWithoutShortenedURLsResponseDTO;

import java.util.List;

public interface GetAllUserUseCase {
    List<UserWithoutShortenedURLsResponseDTO> execute();
}
