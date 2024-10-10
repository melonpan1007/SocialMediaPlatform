package com.example.social_media_platform.service.impl;

import com.example.social_media_platform.dto.CommentDTO;
import com.example.social_media_platform.model.Comment;
import com.example.social_media_platform.repository.CommentRepository;
import com.example.social_media_platform.repository.PostRepository;
import com.example.social_media_platform.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // Constructor-based dependency injection for better testability
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        // Ensure that the comment is associated with a post
        if (comment.getPost() == null || !postRepository.existsById(comment.getPost().getId())) {
            throw new IllegalArgumentException("Comment must be associated with a valid post");
        }
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalStateException("Comment not found"));

        if (comment.getPost() == null || !postRepository.existsById(comment.getPost().getId())) {
            throw new IllegalStateException("Cannot delete comment without a valid post.");
        }

        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> findReplies(Long parentId) {
        return commentRepository.findByParentId(parentId);
    }

    @Override
    public List<CommentDTO> findCommentsByUserId(Long userId) {
        List<Comment> comments = commentRepository.findByUserId(userId);
        return comments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Convert Comment entity to CommentDTO
    private CommentDTO convertToDto(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId()); // Update to set commentId
        dto.setContent(comment.getCommentText());
        dto.setUserId(comment.getUser().getId());
        dto.setPostId(comment.getPost() != null ? comment.getPost().getId() : null);
        dto.setParentId(comment.getParent() != null ? comment.getParent().getId() : null);
        return dto;
    }
}
