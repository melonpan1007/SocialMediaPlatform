package com.example.social_media_platform.controller;

import com.example.social_media_platform.model.Follow;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.service.FollowService;
import com.example.social_media_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follows")
public class FollowController {

    @Autowired
    private FollowService followService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Follow>> getAllFollows() {
        List<Follow> follows = followService.findAll();
        return ResponseEntity.ok(follows);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Follow> getFollowById(@PathVariable Long id) {
        return followService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Follow> saveFollow(@RequestParam Long followerId, @RequestParam Long followedId) {
        if (followerId.equals(followedId)) {
            return ResponseEntity.badRequest().body(null); // Prevent self-following
        }

        User follower = userService.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));
        User followed = userService.findById(followedId)
                .orElseThrow(() -> new RuntimeException("Followed user not found"));

        // Check if already following
        if (followService.isFollowing(follower, followed)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Conflict if already following
        }

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowed(followed);
        follow.setFollowedUserId(followed.getId()); // Set followed user ID
        Follow savedFollow = followService.save(follow);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedFollow);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollow(@PathVariable Long id) {
        if (!followService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build(); // Return 404 if follow not found
        }
        followService.deleteById(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
