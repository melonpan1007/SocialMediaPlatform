package com.example.social_media_platform.service.impl;

import com.example.social_media_platform.dto.CommentDTO;
import com.example.social_media_platform.dto.FollowerDTO;
import com.example.social_media_platform.dto.PostDTO;
import com.example.social_media_platform.dto.UserProfileDTO;
import com.example.social_media_platform.dto.UserProfileRequest;
import com.example.social_media_platform.model.Comment;
import com.example.social_media_platform.model.Post;
import com.example.social_media_platform.model.Role;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.repository.UserRepository;
import com.example.social_media_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserProfileDTO getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToUserProfileDTO(user);
    }

    private UserProfileDTO mapToUserProfileDTO(User user) {
        Set<String> roles = user.getRoles().stream()
                .map(Role::getName) // Ensure 'getName' is defined in Role class
                .collect(Collectors.toSet());

        List<FollowerDTO> followers = user.getFollowers().stream()
                .map(follower -> new FollowerDTO(follower.getId(), follower.getUsername()))
                .collect(Collectors.toList());

        List<FollowerDTO> following = user.getFollowing().stream()
                .map(followedUser -> new FollowerDTO(followedUser.getId(), followedUser.getUsername()))
                .collect(Collectors.toList());

        List<PostDTO> posts = user.getPosts().stream()
                .map(this::mapToPostDTO)
                .collect(Collectors.toList());

        List<CommentDTO> comments = user.getComments().stream()
                .map(this::mapToCommentDTO)
                .collect(Collectors.toList());

        return new UserProfileDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                roles,
                followers,
                following,
                posts,
                comments
        );
    }

    private PostDTO mapToPostDTO(Post post) {
        return new PostDTO(
                post.getId(),
                post.getContent(),
                post.getAuthor() != null ? post.getAuthor().getId() : null // Include author ID
        );
    }


    private CommentDTO mapToCommentDTO(Comment comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getCommentText(),
                comment.getUser().getId(),
                comment.getPost().getId(),
                comment.getParent() != null ? comment.getParent().getId() : null
        );
    }

    @Override
    public List<UserProfileDTO> findAll() {
        return userRepository.findAll().stream()
                .map(this::mapToUserProfileDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void assignRoles(Long userId, Set<Role> roles) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setRoles(roles); // Assign new roles
        userRepository.save(user);
    }

    @Override
    public void removeRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.getRoles().removeIf(role -> role.getId().equals(roleId)); // Remove the specified role
        userRepository.save(user);
    }

    @Override
    public List<UserProfileDTO> getAllUserProfiles() {
        return findAll();
    }

    @Override
    public UserProfileDTO saveUserProfile(User user) {
        // Handle password securely (e.g., hashing)
        // if (user.getPassword() != null && !user.getPassword().isEmpty()) {
        //     user.setPassword(user.getPassword()); // Consider using a hashing function here
        // }
        User savedUser = userRepository.save(user);
        return mapToUserProfileDTO(savedUser);
    }

    @Override
    public UserProfileDTO updateUserProfile(Long userId, UserProfileRequest userProfileRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userProfileRequest.username());
        user.setEmail(userProfileRequest.email());
        user.setPassword(userProfileRequest.password()); // Update password if provided
        User updatedUser = userRepository.save(user);
        return mapToUserProfileDTO(updatedUser);
    }

    @Override
    public void followUser(Long followerId, Long followedId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));
        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new RuntimeException("Followed user not found"));

        // Add to following list of follower
        if (!follower.getFollowing().contains(followed)) {
            follower.getFollowing().add(followed);
        }

        // Add to followers list of followed user
        if (!followed.getFollowers().contains(follower)) {
            followed.getFollowers().add(follower);
        }

        userRepository.save(follower);
        userRepository.save(followed);
    }

    @Override
    public void unfollowUser(Long followerId, Long followedId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));
        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new RuntimeException("Followed user not found"));

        // Remove from following list of follower
        follower.getFollowing().remove(followed);

        // Remove from followers list of followed user
        followed.getFollowers().remove(follower);

        userRepository.save(follower);
        userRepository.save(followed);
    }
}
