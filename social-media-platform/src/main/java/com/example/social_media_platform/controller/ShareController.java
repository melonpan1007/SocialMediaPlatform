/*
package com.example.social_media_platform.controller;

import com.example.social_media_platform.model.Share;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.service.ShareService;
import com.example.social_media_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shares")
public class ShareController {

    @Autowired
    private ShareService shareService;

    @Autowired
    private UserService userService; // Add UserService to find users

    @GetMapping
    public List<Share> getAllShares() {
        return shareService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Share> getShareById(@PathVariable Long id) {
        return shareService.findById(id);
    }

    @PostMapping
    public Share saveShare(@RequestBody Share share, @RequestParam Long userId) {
        User user = userService.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        share.setSharedByUser(user); // Set the user who shared
        return shareService.save(share);
    }

    @DeleteMapping("/{id}")
    public void deleteShare(@PathVariable Long id) {
        shareService.deleteById(id);
    }
}
*/
