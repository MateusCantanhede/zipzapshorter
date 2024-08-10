package com.cantanhede.ds.zipzapshorter.domain.core.repositories;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.URLAccessLog;
import java.util.List;
import java.util.Optional;

public interface URLAccessLogRepository {
    void save(URLAccessLog URLAccessLog);
    Optional<URLAccessLog> findById(long id);
    List<URLAccessLog> findAll();
}
