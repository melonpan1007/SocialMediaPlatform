package com.example.social_media_platform.repository;

import com.example.social_media_platform.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByParentId(Long parentId); // Method to find replies
    List<Comment> findByUserId(Long userId);
}
