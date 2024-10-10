package com.example.social_media_platform.dto;

public class CommentDTO {
    private Long id; // Comment ID
    private String content;
    private Long userId; // ID of the user who made the comment
    private Long postId; // ID of the post the comment belongs to
    private Long parentId; // ID of the parent comment (if any)

    // No-argument constructor
    public CommentDTO() {
    }

    // Parameterized constructor
    public CommentDTO(Long id, String content, Long userId, Long postId, Long parentId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.postId = postId;
        this.parentId = parentId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
