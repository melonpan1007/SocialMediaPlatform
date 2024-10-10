package com.example.social_media_platform.service;

import com.example.social_media_platform.dto.UserProfileDTO;
import com.example.social_media_platform.dto.UserProfileRequest;
import com.example.social_media_platform.model.Role;
import com.example.social_media_platform.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    List<UserProfileDTO> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);

    void assignRoles(Long userId, Set<Role> roles);
    void removeRole(Long userId, Long roleId);

    UserProfileDTO getUserProfile(Long userId);
    List<UserProfileDTO> getAllUserProfiles();
    UserProfileDTO saveUserProfile(User user);
    UserProfileDTO updateUserProfile(Long userId, UserProfileRequest userProfileRequest);

    void followUser(Long followerId, Long followedId);
    void unfollowUser(Long followerId, Long followedId);
}
