package com.example.social_media_platform.controller;

import com.example.social_media_platform.dto.CommentDTO;
import com.example.social_media_platform.dto.FollowerDTO;
import com.example.social_media_platform.dto.PostDTO;
import com.example.social_media_platform.dto.UserProfileDTO;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.model.Comment;
import com.example.social_media_platform.model.Post;
import com.example.social_media_platform.model.Role;
import com.example.social_media_platform.service.CommentService;
import com.example.social_media_platform.service.UserService;
import com.example.social_media_platform.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    // Retrieve all comments
    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.findAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // Retrieve a comment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Optional<Comment> comment = commentService.findById(id);
        return comment.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Save a new comment or reply
    @PostMapping
    public ResponseEntity<CommentDTO> saveComment(@RequestBody CommentDTO commentDTO) {
        logger.info("Received CommentDTO: {}", commentDTO);

        User user = userService.findById(commentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + commentDTO.getUserId()));

        Comment comment = new Comment();
        comment.setCommentText(commentDTO.getContent());
        comment.setUser(user);

        if (commentDTO.getPostId() != null) {
            Post post = postService.findById(commentDTO.getPostId())
                    .orElseThrow(() -> new RuntimeException("Post not found with ID: " + commentDTO.getPostId()));
            comment.setPost(post);
        }

        // Set parent comment if it's a reply
        if (commentDTO.getParentId() != null) {
            Comment parentComment = commentService.findById(commentDTO.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent comment not found with ID: " + commentDTO.getParentId()));
            comment.setParent(parentComment);
        }

        Comment savedComment = commentService.save(comment);
        logger.info("Saved comment: {}", savedComment);

        return new ResponseEntity<>(convertToDto(savedComment), HttpStatus.CREATED);
    }

    // Delete a comment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        try {
            commentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Return 204 on successful deletion
        } catch (IllegalStateException e) {
            logger.error("Error deleting comment: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            logger.error("Error deleting comment: {}", e.getMessage());
            return new ResponseEntity<>("Comment not found", HttpStatus.NOT_FOUND);
        }
    }

    // Get replies for a parent comment
    @GetMapping("/replies/{parentId}")
    public ResponseEntity<List<Comment>> getReplies(@PathVariable Long parentId) {
        List<Comment> replies = commentService.findReplies(parentId);
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }

    // Retrieve comments by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable Long userId) {
        User user = userService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // Create UserProfileDTO without password
        UserProfileDTO profileDTO = new UserProfileDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()), // Convert roles to String
                null, // Placeholder for followers, set below
                null, // Placeholder for following, set below
                null, // Posts list (set below)
                null  // Comments list (set below)
        );

        // Convert the List<Post> to List<PostDTO>
        List<PostDTO> postDTOs = postService.findByAuthor(userId).stream()
                .map(this::convertToPostDto)
                .collect(Collectors.toList());

        profileDTO.setPosts(postDTOs); // Set the converted postDTOs
        profileDTO.setComments(commentService.findCommentsByUserId(userId));

        // Convert followers and following from User to FollowerDTO
        List<FollowerDTO> followerDTOs = user.getFollowers().stream()
                .map(FollowerDTO::new) // Assuming FollowerDTO has a constructor that takes User as a parameter
                .collect(Collectors.toList());

        List<FollowerDTO> followingDTOs = user.getFollowing().stream()
                .map(FollowerDTO::new) // Assuming FollowerDTO has a constructor that takes User as a parameter
                .collect(Collectors.toList());

        profileDTO.setFollowers(followerDTOs); // Set followers
        profileDTO.setFollowing(followingDTOs); // Set following

        return new ResponseEntity<>(profileDTO, HttpStatus.OK);
    }

    // Convert Post to PostDTO
    private PostDTO convertToPostDto(Post post) {
        PostDTO dto = new PostDTO();
        dto.setPostId(post.getId()); // Ensure your Post class has a getId() method
        dto.setPostContent(post.getContent()); // Ensure your Post class has a getContent() method
        // Remove popularity score as it's no longer part of PostDTO

        return dto;
    }

    // Convert Comment to CommentDTO
    private CommentDTO convertToDto(Comment comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getCommentText(),
                comment.getUser().getId(),
                comment.getPost() != null ? comment.getPost().getId() : null,
                comment.getParent() != null ? comment.getParent().getId() : null
        );
    }
}
