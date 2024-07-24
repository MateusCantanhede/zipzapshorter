package com.cantanhede.ds.zipzapshorter.domain.core.usecases;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;

import java.util.List;

public interface GetAllUserUsecase {
    List<User> execute();
}
