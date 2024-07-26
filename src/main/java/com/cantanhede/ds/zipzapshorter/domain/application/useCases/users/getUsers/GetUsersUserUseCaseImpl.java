package com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.getUsers;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared.UserWithoutShortenedURLsResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.GetAllUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersUserUseCaseImpl implements GetAllUserUseCase {
    private final UserRepository userRepository;
    @Autowired
    public GetUsersUserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<UserWithoutShortenedURLsResponseDTO> execute() {
        var users = userRepository.findAll();
        return users.stream().map(user -> new UserWithoutShortenedURLsResponseDTO(user.getId(),user.getUsername(),user.getPassword(),user.getEmail())).toList();
    }
}
