/*
package com.example.social_media_platform.controller;

import com.example.social_media_platform.datastructures.UserDataStore;
import com.example.social_media_platform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users-data")
public class UserDataStoreController {

    @Autowired
    private UserDataStore userDataStore;

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        userDataStore.addUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userDataStore.getUser(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable Long id) {
        userDataStore.removeUser(id);
        return ResponseEntity.ok().build();
    }
}
*/
