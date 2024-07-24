package com.cantanhede.ds.zipzapshorter.infrastructure.dataSource;

import com.cantanhede.ds.zipzapshorter.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbContext extends JpaRepository<UserEntity, Long> {

}
