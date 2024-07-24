package com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.createUser;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.CreateUserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUsecaseImpl  implements CreateUserUsecase {

    private final UserRepository userRepository;

    @Autowired
    public CreateUserUsecaseImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User execute(CreateUserRequest request) {
        //add validator caso precise
        var user = new User(
                request.username(),
                request.password(),
                request.email()
        );
        this.userRepository.save(user);
        return user;
    }
}
