package com.cantanhede.ds.zipzapshorter.domain.application.useCases.users.shared;

import com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.shared.ShortenedURLResponseDTO;

import java.util.List;

public record UserWithoutShortenedURLsResponseDTO(
    long id,
    String username,
    String password,
    String email
){
    // add métodos caso precise
}
