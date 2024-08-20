package com.cantanhede.ds.zipzapshorter.domain.application.useCases.statistics.registerClick;

import com.cantanhede.ds.zipzapshorter.domain.application.exceptions.ApplicationException;
import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLResponseDTO;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;
import com.cantanhede.ds.zipzapshorter.domain.core.entities.Statistics;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.ShortenedURLRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.repositories.StatisticsRepository;
import com.cantanhede.ds.zipzapshorter.domain.core.usecases.RegisterClickUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

@Service
public class RegisterClickUseCaseImpl implements RegisterClickUseCase {
    private final StatisticsRepository statisticsRepository;
    private final ShortenedURLRepository shortenedURLRepository;
    public RegisterClickUseCaseImpl(StatisticsRepository statisticsRepository, ShortenedURLRepository shortenedURLRepository) {
        this.statisticsRepository = statisticsRepository;
        this.shortenedURLRepository = shortenedURLRepository;
    }

    @Transactional
    public ShortenedURLResponseDTO execute(RegisterClickRequest request) throws ApplicationException {

        var shortened = shortenedURLRepository.findByShortenedURL(request.shortURL());
        if (shortened.isEmpty()) {
            throw new ApplicationException("Short URL not found");
        }
        ShortenedURL shortenedURL = shortened.get();
        //se nao tem cria statistic
        Statistics statistics = new Statistics(0L, shortenedURL, 0,0,request.ipClient(),new HashMap<>());
        var statisticsOptional = statisticsRepository.findByShortUrlId(shortenedURL.getId());
        if (statisticsOptional.isPresent()) {
            statistics = statisticsOptional.get();
        }
        // Atualiza o total de cliques
        statistics.setTotalClicks(statistics.getTotalClicks() + 1);

        //verifica usuarios unicos
        var statisticsOptByIpClient = statisticsRepository.findByIpClient(request.ipClient());
        if (statisticsOptByIpClient.isEmpty()) {
            // Atualiza o número de visitantes únicos (essa lógica pode variar dependendo de como você define um visitante único)
            statistics.setUniqueVisitors(statistics.getUniqueVisitors() + 1);
        }

        // Atualiza os cliques por data
        OffsetDateTime today = OffsetDateTime.now().truncatedTo(ChronoUnit.DAYS);
        statistics.getClicksByDate().merge(today, 1L, Long::sum);

        // Salva as mudanças
        statisticsRepository.save(statistics);
        return new ShortenedURLResponseDTO(shortenedURL.getId(),shortenedURL.getOriginalUrl(),shortenedURL.getShortUrl(),shortenedURL.getCreationDate(),shortenedURL.getExpirationDate(),shortenedURL.getUser().getId());
    }
}
