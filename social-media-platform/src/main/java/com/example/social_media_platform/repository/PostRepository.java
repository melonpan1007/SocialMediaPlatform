package com.example.social_media_platform.repository;

import com.example.social_media_platform.model.Post;
import com.example.social_media_platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Find posts by author (User)
    List<Post> findByAuthor(User author);

    // Alternative method to find posts by author ID (in case you need it)
    List<Post> findByAuthorId(Long userId);
}
