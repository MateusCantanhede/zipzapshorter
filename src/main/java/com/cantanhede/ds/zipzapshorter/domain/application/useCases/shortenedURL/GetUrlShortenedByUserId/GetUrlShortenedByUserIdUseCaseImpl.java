package com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.GetUrlShortenedByUserId;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.ShortenedURLRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.GetUrlShortenerByUserIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUrlShortenedByUserIdUseCaseImpl implements GetUrlShortenerByUserIdUseCase {
    private final UserRepository userRepository;
    private final ShortenedURLRepository shortenedURLRepository;

    public GetUrlShortenedByUserIdUseCaseImpl(UserRepository userRepository, ShortenedURLRepository shortenedURLRepository) {
        this.userRepository = userRepository;
        this.shortenedURLRepository = shortenedURLRepository;
    }

    @Override
    public List<ShortenedURLResponseDTO> execute(long userId) throws ApplicationException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ApplicationException("User not found"));
        var shortenedURLs = shortenedURLRepository.findByUserId(userId);
        user.setCreatedUrls(shortenedURLs);
        return user.getCreatedUrls().stream().map(shortenedURL -> new ShortenedURLResponseDTO(shortenedURL.getId(),shortenedURL.getOriginalUrl(),shortenedURL.getShortUrl(),shortenedURL.getCreationDate(),shortenedURL.getExpirationDate(),shortenedURL.getUser().getId())).toList();
    }
}
