package com.cantanhede.ds.zipzapshorter.infrastructure.mappers;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.UserEntity;

import java.util.function.Function;

public class UserMapper {
    public static  UserEntity mapToEntity(User user) {
        return new UserEntity(user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    public static  User mapToDomain(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
    }
}
