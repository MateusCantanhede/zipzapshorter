package com.cantanhede.ds.zipzapshorter.infrastructure.repositoriesImpl;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.infrastructure.dataSource.DbContext;
import com.cantanhede.ds.zipzapshorter.infrastructure.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private  final DbContext context;

    @Autowired
    public UserRepositoryImpl(DbContext context) {
        this.context = context;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = mapToEntity(user);
        context.save(userEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return context.findById(id).map(this::mapToDomain);
    }

    @Override
    public List<User> findAll() {
        return context.findAll().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }
    //TODO: add em uma extension class
    private UserEntity mapToEntity(User user) {
        return new UserEntity(user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    private User mapToDomain(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
    }
}
