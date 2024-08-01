 package com.cantanhede.ds.zipzapshorter.infrastructure.dataSource;

import com.cantanhede.ds.zipzapshorter.infrastructure.entities.URLAccessLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLAccessLogJpaDatasource extends JpaRepository<URLAccessLogEntity, Long> {

}
