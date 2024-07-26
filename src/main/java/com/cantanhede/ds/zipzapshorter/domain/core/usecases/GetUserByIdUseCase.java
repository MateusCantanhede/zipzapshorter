package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared.UserResponseDTO;

public interface GetUserByIdUseCase {
    UserResponseDTO execute(long userId) throws ApplicationException;
}
