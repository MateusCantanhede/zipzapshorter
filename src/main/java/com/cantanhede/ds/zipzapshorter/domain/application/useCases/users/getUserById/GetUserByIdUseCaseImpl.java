package com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.getUserById;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared.UserResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.GetUserByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {
    private final UserRepository userRepository;
    @Autowired
    public GetUserByIdUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserResponseDTO execute(long userId) throws ApplicationException {
        var user = userRepository.findById(userId).orElseThrow(()->new ApplicationException("User not found"));
        var shortList = user.getCreatedUrls().stream().map(ShortenedURL -> new ShortenedURLResponseDTO(ShortenedURL.getId(),ShortenedURL.getOriginalUrl(),ShortenedURL.getShortUrl(),ShortenedURL.getCreationDate(),ShortenedURL.getExpirationDate(),ShortenedURL.getUser().getId())).toList();
        return new UserResponseDTO(user.getId(), user.getPassword(), user.getEmail(), user.getEmail(),shortList );
    }
}
