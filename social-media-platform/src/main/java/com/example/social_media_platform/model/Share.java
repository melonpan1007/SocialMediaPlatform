/*
package com.example.social_media_platform.model;

import jakarta.persistence.*;

@Entity
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;

    @ManyToOne // Many shares can belong to one user
    @JoinColumn(name = "user_id", nullable = false)
    private User sharedByUser; // Change sharedBy to a User object

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public User getSharedByUser() {
        return sharedByUser;
    }

    public void setSharedByUser(User sharedByUser) {
        this.sharedByUser = sharedByUser;
    }
}
*/
