package com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.GetUrlShortenedByShortenedURL;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.ShortenedURLRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.GetUrlShortenerByShortenedURLUseCase;
import org.springframework.stereotype.Service;

@Service
public class GetUrlShortenedByShortenedURLUseCaseImpl implements GetUrlShortenerByShortenedURLUseCase {

    private final ShortenedURLRepository shortenedURLRepository;

    public GetUrlShortenedByShortenedURLUseCaseImpl(ShortenedURLRepository shortenedURLRepository) {
        this.shortenedURLRepository = shortenedURLRepository;
    }

    @Override
    public ShortenedURLResponseDTO execute(String shortenedURL) throws ApplicationException {
        var shortened = shortenedURLRepository.findByShortenedURL(shortenedURL).orElseThrow(() -> new ApplicationException("ShortURL not found"));
        return  new ShortenedURLResponseDTO(shortened.getId(),shortened.getOriginalUrl(),shortened.getShortUrl(),shortened.getCreationDate(),shortened.getExpirationDate(),shortened.getUser().getId());
    }
}
