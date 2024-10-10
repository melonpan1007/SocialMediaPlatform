package com.example.social_media_platform.service;

import com.example.social_media_platform.model.Post;
import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> findAll();
    Optional<Post> findById(Long id);
    Post save(Post post);
    void deleteById(Long id);

    // New method to find posts by author
    List<Post> findByAuthor(Long userId);

    List<Post> getTopPosts(int n); // New method for getting top posts
}
