/*
package com.example.social_media_platform.model;

import jakarta.persistence.*;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    @ManyToOne // Establish a many-to-one relationship with User
    @JoinColumn(name = "user_id", nullable = false) // Foreign key column
    private User uploader; // Change from String to User


    // Constructors
    public Photo() {}

    public Photo(Long id, String url, User uploader) { // Change to User
        this.id = id;
        this.url = url;
        this.uploader = uploader;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUploader() {
        return uploader; // Return User instead of String
    }

    public void setUploader(User uploader) {
        this.uploader = uploader; // Set User
    }
}
*/
