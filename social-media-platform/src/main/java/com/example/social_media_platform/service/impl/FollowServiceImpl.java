package com.example.social_media_platform.service.impl;

import com.example.social_media_platform.model.Follow;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.repository.FollowRepository;
import com.example.social_media_platform.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Override
    public List<Follow> findAll() {
        return followRepository.findAll();
    }

    @Override
    public Optional<Follow> findById(Long id) {
        return followRepository.findById(id);
    }

    @Override
    public Follow save(Follow follow) {
        return followRepository.save(follow);
    }

    @Override
    public void deleteById(Long id) {
        followRepository.deleteById(id);
    }

    @Override
    public List<User> getFollowers(User followedUser) {
        return followRepository.findAll().stream()
                .filter(follow -> follow.getFollowed().equals(followedUser))
                .map(Follow::getFollower)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getFollowedUsers(User follower) {
        return followRepository.findAll().stream()
                .filter(follow -> follow.getFollower().equals(follower))
                .map(Follow::getFollowed)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllFollowings() {
        return followRepository.findAll().stream()
                .map(Follow::getFollowed)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<Follow> findByFollowerId(Long followerId) {
        return followRepository.findAll().stream()
                .filter(follow -> follow.getFollower().getId().equals(followerId))
                .collect(Collectors.toList());
    }

    public boolean isFollowing(User follower, User followed) {
        return followRepository.existsByFollowerAndFollowed(follower, followed);
    }
}
