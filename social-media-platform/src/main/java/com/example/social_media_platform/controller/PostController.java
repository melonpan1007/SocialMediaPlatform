package com.example.social_media_platform.controller;

import com.example.social_media_platform.dto.PostDTO;
import com.example.social_media_platform.model.Post;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.service.PostService;
import com.example.social_media_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService; // Inject UserService

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return postService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO) {
        // Fetch the author using userService
        User author = userService.findById(postDTO.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Post post = new Post();
        post.setContent(postDTO.getPostContent());
        post.setAuthor(author); // Set the author

        Post savedPost = postService.save(post);

        // Create PostDTO from saved Post
        PostDTO savedPostDTO = new PostDTO(
                savedPost.getId(),                 // postId
                savedPost.getContent(),            // postContent
                savedPost.getAuthor().getId()      // authorId
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPostDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (postService.findById(id).isPresent()) {
            postService.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.notFound().build(); // 404 Not Found
    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostsByAuthor(@PathVariable Long userId) {
        return postService.findByAuthor(userId);
    }

    @GetMapping("/top/{n}")
    public List<Post> getTopPosts(@PathVariable int n) {
        return postService.getTopPosts(n);
    }
}
