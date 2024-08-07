package com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLResponseDTO;

import java.util.List;

public record UserResponseDTO(
    long id,
    String username,
    String password,
    String email,
    List<ShortenedURLResponseDTO> createdUrls
){
    // add métodos caso precise
}
