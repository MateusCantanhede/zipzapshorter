package com.cantanhede.ds.zipzapshorter.infrastructure.dataSource;

import com.cantanhede.ds.zipzapshorter.infrastructure.entities.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsJpaDatasource extends JpaRepository<StatisticsEntity, Long> {

}
