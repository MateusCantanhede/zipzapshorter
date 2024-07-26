package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.createUser.CreateUserRequest;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared.UserMessageResponseDTO;

public interface CreateUserUseCase {
    UserMessageResponseDTO execute(CreateUserRequest request);
}
