/*
package com.example.social_media_platform.controller;

import com.example.social_media_platform.datastructures.PostHistory;
import com.example.social_media_platform.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post-history")
public class PostHistoryController {

    @Autowired
    private PostHistory postHistory;

    // Endpoint to delete a post (push it onto the history stack)
    @PostMapping
    public ResponseEntity<Void> deletePost(@RequestBody Post post) {
        postHistory.push(post);
        return ResponseEntity.ok().build();
    }

    // Endpoint to restore the last deleted post
    @GetMapping
    public ResponseEntity<Post> restorePost() {
        Post restoredPost = postHistory.pop();
        if (restoredPost != null) {
            return ResponseEntity.ok(restoredPost);
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if no post to restore
        }
    }
}
*/
