package com.cantanhede.ds.zipzapshorter.infrastructure.dataSource;

import com.cantanhede.ds.zipzapshorter.infrastructure.entities.ShortenedURLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortenedURLJpaRepository extends JpaRepository<ShortenedURLEntity, Long> {
    List<ShortenedURLEntity> findByUserId(Long userId);
}
