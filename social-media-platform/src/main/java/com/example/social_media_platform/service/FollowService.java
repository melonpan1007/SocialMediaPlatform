package com.example.social_media_platform.service;

import com.example.social_media_platform.model.Follow;
import com.example.social_media_platform.model.User;

import java.util.List;
import java.util.Optional;

public interface FollowService {
    List<Follow> findAll();
    Optional<Follow> findById(Long id);
    Follow save(Follow follow);
    void deleteById(Long id);


    List<User> getFollowers(User followedUser);
    List<User> getFollowedUsers(User follower);
    List<User> getAllFollowings(); // New method to get all followings
    List<Follow> findByFollowerId(Long followerId);
    boolean isFollowing(User follower, User followed);

}
