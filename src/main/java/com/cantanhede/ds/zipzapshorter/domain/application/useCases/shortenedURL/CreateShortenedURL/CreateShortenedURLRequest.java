package com.cantanhede.ds.zipzapshorter.domain.application.useCases.shortenedURL.CreateShortenedURL;

public record CreateShortenedURLRequest(long userId, String originalUrl){
}
