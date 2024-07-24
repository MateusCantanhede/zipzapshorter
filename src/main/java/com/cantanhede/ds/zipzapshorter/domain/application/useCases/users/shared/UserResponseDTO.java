package com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared;

import com.cantanhede.ds.zipzapshorter.domain.core.entities.ShortenedURL;

import java.util.List;

public record UserResponseDTO(
    long id,
    String username,
    String password,
    String email,
    List<ShortenedURL> createdUrls
){
    // add métodos caso precise
}
