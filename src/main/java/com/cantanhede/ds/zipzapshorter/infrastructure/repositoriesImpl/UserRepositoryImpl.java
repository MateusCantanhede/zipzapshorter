package com.cantanhede.ds.zipzapshorter.infrastructure.repositoriesImpl;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.infrastructure.dataSource.UserJpaDatasource;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.UserEntity;
import com.cantanhede.ds.zipzapshorter.infrastructure.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaDatasource dataSource;

    @Autowired
    public UserRepositoryImpl(UserJpaDatasource context) {
        this.dataSource = context;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = UserMapper.mapToEntity(user);
        dataSource.save(userEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return dataSource.findById(id).map(UserMapper::mapToDomain);
    }

    @Override
    public List<User> findAll() {
        return dataSource.findAll().stream()
                .map(UserMapper::mapToDomain)
                .collect(Collectors.toList());
    }
}
