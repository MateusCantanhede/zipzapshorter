package com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.findByShortUrlId;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.registerClick.RegisterClickRequest;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.shared.StatisticResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.Statistics;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.ShortenedURLRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.StatisticsRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.FindStatisticsByShortUrlIdUseCase;
import org.springframework.stereotype.Service;

@Service
public class FindStatisticsByShorUrlIdUseCaseImpl implements FindStatisticsByShortUrlIdUseCase {
    private final StatisticsRepository statisticsRepository;
    private final ShortenedURLRepository shortenedURLRepository;

    public FindStatisticsByShorUrlIdUseCaseImpl(StatisticsRepository statisticsRepository, ShortenedURLRepository shortenedURLRepository) {
        this.statisticsRepository = statisticsRepository;
        this.shortenedURLRepository = shortenedURLRepository;
    }
    public StatisticResponseDTO execute(String shortURL) throws ApplicationException {

        var shortened = shortenedURLRepository.findByShortenedURL(shortURL);
        if (shortened.isEmpty()) {
            throw new ApplicationException("Short URL not found");
        }
        ShortenedURL shortenedURL = shortened.get();
        var statisticsOptional = statisticsRepository.findByShortUrlId(shortenedURL.getId());
        if (statisticsOptional.isEmpty()) {
            throw new ApplicationException("Statistic not found");
        }
        Statistics statistics = statisticsOptional.get();

        return new StatisticResponseDTO(statistics.getId(),statistics.getShortUrl(),statistics.getTotalClicks(),statistics.getUniqueVisitors(),statistics.getIpClient(),statistics.getClicksByDate());
    }
}
