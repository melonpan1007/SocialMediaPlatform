package com.example.social_media_platform.dto;

import com.example.social_media_platform.model.Role;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserProfileDTO {
    private Long id;
    private String username;
    private String email;
    private Set<String> roles; // Remove password for security
    private List<FollowerDTO> followers;
    private List<FollowerDTO> following;
    private List<PostDTO> posts;
    private List<CommentDTO> comments;

    // Default constructor
    public UserProfileDTO() {}

    // Constructor with all fields except password
    public UserProfileDTO(Long id, String username, String email,
                          Set<String> roles, List<FollowerDTO> followers,
                          List<FollowerDTO> following, List<PostDTO> posts,
                          List<CommentDTO> comments) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
        this.comments = comments;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public List<FollowerDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FollowerDTO> followers) {
        this.followers = followers;
    }

    public List<FollowerDTO> getFollowing() {
        return following;
    }

    public void setFollowing(List<FollowerDTO> following) {
        this.following = following;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    // Converts Role entities to Strings
    public void setRolesFromEntities(Set<Role> roles) {
        this.roles = roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
