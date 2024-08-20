package com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.createUser;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared.UserMessageResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;

    @Autowired
    public CreateUserUseCaseImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserMessageResponseDTO execute(CreateUserRequest request) {
        var user = new User(
                request.username(),
                request.password(),
                request.email()
        );
        this.userRepository.save(user);
        return new UserMessageResponseDTO("User created successfully");
    }
}
