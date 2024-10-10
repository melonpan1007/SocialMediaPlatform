package com.example.social_media_platform.dto;

import com.example.social_media_platform.model.User;

public class FollowerDTO {
    private Long id;
    private String username;

    // Constructor for creating FollowerDTO from User object
    public FollowerDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    // Constructor for creating FollowerDTO with id and username
    public FollowerDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
