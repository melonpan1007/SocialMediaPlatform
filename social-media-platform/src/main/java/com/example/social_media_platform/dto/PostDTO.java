package com.example.social_media_platform.dto;

public class PostDTO {
    private Long postId;          // Post ID
    private String postContent;   // Post content
    private Long authorId;        // Author ID

    // Getters and Setters
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    // Constructor
    public PostDTO(Long postId, String postContent, Long authorId) {
        this.postId = postId;
        this.postContent = postContent;
        this.authorId = authorId;
    }

    // Default constructor
    public PostDTO() {}
}
