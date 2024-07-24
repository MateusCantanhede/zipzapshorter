package com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.GetUrlShortenerByUserId;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.User;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.ShortenedURLRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.UserRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.GetUrlShortenerByUserIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUrlShortenerByUserIdUsecaseImpl implements GetUrlShortenerByUserIdUsecase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShortenedURLRepository shortenedURLRepository;

    @Override
    public List<ShortenedURL> execute(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setCreatedUrls(shortenedURLRepository.findByUserId(userId));
        return user.getCreatedUrls();
    }
}
