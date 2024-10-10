/*
package com.example.social_media_platform.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Sender relationship to User
    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false) // Mapping the sender_id to User entity
    private User sender;

    // Receiver relationship to User
    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false) // Mapping the receiver_id to User entity
    private User receiver;

    // Message content
    private String content;

    private LocalDateTime timestamp; // Add this field if not already present

    // Constructors
    public Message() {}

    public Message(User sender, User receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}*/
