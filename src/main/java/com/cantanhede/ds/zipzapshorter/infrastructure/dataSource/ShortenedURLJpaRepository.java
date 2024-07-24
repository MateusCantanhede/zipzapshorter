package com.cantanhede.ds.zipzapshorter.infrastructure.dataSource;

import com.cantanhede.ds.zipzapshorter.infrastructure.entities.ShortenedURLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortenedURLJpaRepository extends JpaRepository<ShortenedURLEntity, Long> {

}
