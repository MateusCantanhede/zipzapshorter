package com.cantanhede.ds.zipzapshorter.domain.core.entities;

import lombok.*;

import java.util.List;

@Setter
@Getter
public class User {
    private long id;
    private String username;
    private String password;
    private String email;
    private List<ShortenedURL> createdUrls;

    public User(long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
