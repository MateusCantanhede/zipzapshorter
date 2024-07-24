package com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.getUsers;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.GetAllUserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersUserUsecaseImpl implements GetAllUserUsecase {
    private final UserRepository userRepository;
    @Autowired
    public GetUsersUserUsecaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> execute() {
        return userRepository.findAll();
    }
}
