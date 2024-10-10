/*
package com.example.social_media_platform.controller;

import com.example.social_media_platform.model.UserLike;
import com.example.social_media_platform.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping
    public List<UserLike> getAllLikes() {
        return likeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserLike> getLikeById(@PathVariable Long id) {
        return likeService.findById(id);
    }

    @PostMapping
    public UserLike saveLike(@RequestBody UserLike like) {
        // Manually set the userId here, or expect it to be provided in the request body
        // If the `userId` is passed in the body along with the postId
        return likeService.save(like);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id) {
        likeService.deleteById(id);
    }
}
*/
