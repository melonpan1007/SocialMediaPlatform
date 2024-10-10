package com.example.social_media_platform.repository;

import com.example.social_media_platform.model.Follow;
import com.example.social_media_platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByUserId(Long userId);
    boolean existsByFollowerAndFollowed(User follower, User followed);

}