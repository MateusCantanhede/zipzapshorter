package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.createUser.CreateUserRequest;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;

public interface CreateUserUsecase {
    User execute(CreateUserRequest request);
}
