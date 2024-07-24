package com.cantanhede.ds.zipzapshorter.controllers;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.createUser.CreateUserUsecaseImpl;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.createUser.CreateUserRequest;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.getUsers.GetUsersUserUsecaseImpl;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUsecaseImpl createUser;
    private final GetUsersUserUsecaseImpl getUsers;

    public UserController(CreateUserUsecaseImpl createUser, GetUsersUserUsecaseImpl getUsers) {
        this.createUser = createUser;
        this.getUsers = getUsers;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
        var response = createUser.execute(createUserRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        var response = getUsers.execute();
        return ResponseEntity.ok(response);
    }
}
