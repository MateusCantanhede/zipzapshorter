package com.cantanhede.ds.zipzapshorter.domain.core.repositories;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
}
