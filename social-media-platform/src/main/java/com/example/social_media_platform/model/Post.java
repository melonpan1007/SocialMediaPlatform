package com.example.social_media_platform.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private int likes;

    // A post can have multiple comments
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments; // Updated from int to List<Comment>

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public List<Comment> getComments() { // Updated getter for comments
        return comments;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComments(List<Comment> comments) { // Updated setter for comments
        this.comments = comments;
    }

    // Method to calculate popularity score
    public int getPopularityScore() {
        return likes + (comments != null ? comments.size() : 0);
    }
}
