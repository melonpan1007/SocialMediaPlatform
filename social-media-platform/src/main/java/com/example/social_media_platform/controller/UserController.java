package com.example.social_media_platform.controller;

import com.example.social_media_platform.dto.UserProfileDTO;
import com.example.social_media_platform.dto.UserProfileRequest;
import com.example.social_media_platform.model.Role;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.service.RoleService;
import com.example.social_media_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    // Follow a user
    @PostMapping(value = "/{followerId}/follow/{followeeId}", produces = "application/json")
    public ResponseEntity<String> followUser(@PathVariable Long followerId, @PathVariable Long followeeId) {
        User follower = userService.findById(followerId).orElseThrow(() -> new IllegalArgumentException("Follower not found"));
        User followee = userService.findById(followeeId).orElseThrow(() -> new IllegalArgumentException("Followee not found"));

        follower.getFollowing().add(followee);
        followee.getFollowers().add(follower);

        userService.save(follower);
        userService.save(followee);

        return ResponseEntity.ok("Successfully followed user");
    }

    // Unfollow a user
    @DeleteMapping(value = "/{userId}/unfollow/{followeeId}", produces = "application/json")
    public ResponseEntity<?> unfollowUser(@PathVariable Long userId, @PathVariable Long followeeId) {
        try {
            User user = userService.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
            User followee = userService.findById(followeeId).orElseThrow(() -> new IllegalArgumentException("Followee not found"));

            user.getFollowing().remove(followee);
            followee.getFollowers().remove(user);

            userService.save(user);
            userService.save(followee);

            return ResponseEntity.ok("Successfully unfollowed user");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error unfollowing user");
        }
    }

    // Fetch all user profiles
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<UserProfileDTO>> getAllUsers() {
        List<UserProfileDTO> userProfiles = userService.getAllUserProfiles();
        return ResponseEntity.ok(userProfiles);
    }

    // Fetch user profile by ID
    @GetMapping(value = "/{userId}", produces = "application/json")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        try {
            UserProfileDTO userProfile = userService.getUserProfile(userId);
            return ResponseEntity.ok(userProfile);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + userId + " not found.");
        }
    }

    // Save user profile
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserProfileDTO> saveUser(@RequestBody UserProfileRequest userProfileRequest) {
        try {
            User user = new User();
            user.setUsername(userProfileRequest.username());
            user.setEmail(userProfileRequest.email());
            user.setPassword(userProfileRequest.password());

            UserProfileDTO savedUserProfile = userService.saveUserProfile(user);
            return new ResponseEntity<>(savedUserProfile, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Update an existing user profile
    @PutMapping(value = "/{userId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserProfileDTO> updateUser(@PathVariable Long userId,
                                                     @RequestBody UserProfileRequest userProfileRequest) {
        try {
            UserProfileDTO updatedUserProfile = userService.updateUserProfile(userId, userProfileRequest);
            return ResponseEntity.ok(updatedUserProfile);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Assign roles to the user
    @PostMapping(value = "/{userId}/roles", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> assignRoles(@PathVariable Long userId,
                                         @RequestBody Set<Long> roleIds) {
        try {
            Set<Role> roles = new HashSet<>();
            for (Long roleId : roleIds) {
                Role role = roleService.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Role not found"));
                roles.add(role);
            }

            userService.assignRoles(userId, roles);
            return ResponseEntity.ok("Roles assigned successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid roles or user");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error assigning roles");
        }
    }

    // Remove a specific role from the user
    @DeleteMapping(value = "/{userId}/roles/{roleId}", produces = "application/json")
    public ResponseEntity<?> removeRole(@PathVariable Long userId, @PathVariable Long roleId) {
        try {
            Optional<Role> roleOpt = roleService.findById(roleId);
            if (roleOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found.");
            }

            userService.removeRole(userId, roleId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing role");
        }
    }

    // Delete a user by ID
    @DeleteMapping(value = "/{userId}", produces = "application/json")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteById(userId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }
    }
}
