package com.example.social_media_platform.service;

import com.example.social_media_platform.dto.CommentDTO;
import com.example.social_media_platform.model.Comment;
import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findAll();
    Optional<Comment> findById(Long id);
    Comment save(Comment comment);
    void deleteById(Long id);
    List<Comment> findReplies(Long parentId); // Method to get replies for a comment
    List<CommentDTO> findCommentsByUserId(Long userId);
}
