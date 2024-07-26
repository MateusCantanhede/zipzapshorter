package com.cantanhede.ds.zipzapshorter.controllers;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.createUser.CreateUserUseCaseImpl;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.createUser.CreateUserRequest;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.getUserById.GetUserByIdUseCaseImpl;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.getUsers.GetUsersUserUseCaseImpl;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared.UserMessageResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared.UserResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared.UserWithoutShortenedURLsResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.GetUrlShortenerByUserIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "Controller for Creating user")
public class UserController {
    private final CreateUserUseCaseImpl createUser;
    private final GetUsersUserUseCaseImpl getUsers;
    private final GetUserByIdUseCaseImpl getUserById;
    private final GetUrlShortenerByUserIdUseCase getUrlShortenerByUserIdUsecase;


    public UserController(CreateUserUseCaseImpl createUser, GetUsersUserUseCaseImpl getUsers, GetUserByIdUseCaseImpl getUserById, GetUrlShortenerByUserIdUseCase getUrlShortenerByUserIdUsecase) {
        this.createUser = createUser;
        this.getUsers = getUsers;
        this.getUserById = getUserById;
        this.getUrlShortenerByUserIdUsecase = getUrlShortenerByUserIdUsecase;
    }
    @Operation(summary = "Create User", description = "Create a user")
    @PostMapping
    public ResponseEntity<UserMessageResponseDTO> createUser(@RequestBody CreateUserRequest createUserRequest) {
        var response = createUser.execute(createUserRequest);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get user", description = "Get user by id")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable long id) throws ApplicationException {
        var response = getUserById.execute(id);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get users", description = "Get all users")
    @GetMapping
    public ResponseEntity<List<UserWithoutShortenedURLsResponseDTO>> getAllUsers() {
        var response = getUsers.execute();
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get URLs by user ID", description = "Get all shortened URLs for a specific user")
    @GetMapping("/{userId}/urls")
    public ResponseEntity<List<ShortenedURLResponseDTO>> getUrlsByUserId(@PathVariable long userId) throws ApplicationException {
        var response = getUrlShortenerByUserIdUsecase.execute(userId);
        return ResponseEntity.ok(response);
    }
}
