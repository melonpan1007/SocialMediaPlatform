/*
package com.example.social_media_platform.controller;

import com.example.social_media_platform.datastructures.UsernameTrie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usernames")
public class UsernameTrieController {

    @Autowired
    private UsernameTrie usernameTrie;

    @PostMapping
    public ResponseEntity<Void> addUsername(@RequestBody String username) {
        usernameTrie.insert(username);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
        boolean exists = usernameTrie.search(username);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/startsWith/{prefix}")
    public ResponseEntity<Boolean> startsWith(@PathVariable String prefix) {
        boolean exists = usernameTrie.startsWith(prefix);
        return ResponseEntity.ok(exists);
    }
}
*/
