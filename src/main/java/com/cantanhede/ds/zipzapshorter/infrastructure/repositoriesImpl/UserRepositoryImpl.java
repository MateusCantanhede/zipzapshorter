package com.cantanhede.ds.zipzapshorter.infrastructure.repositoriesImpl;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.infrastructure.dataSource.UserJpaRepository;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.UserEntity;
import com.cantanhede.ds.zipzapshorter.infrastructure.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private  final UserJpaRepository context;

    @Autowired
    public UserRepositoryImpl(UserJpaRepository context) {
        this.context = context;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = UserMapper.mapToEntity(user);
        context.save(userEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return context.findById(id).map(UserMapper::mapToDomain);
    }

    @Override
    public List<User> findAll() {
        return context.findAll().stream()
                .map(UserMapper::mapToDomain)
                .collect(Collectors.toList());
    }
}
