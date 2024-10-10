/*
package com.example.social_media_platform.service.impl;

import com.example.social_media_platform.model.UserLike;
import com.example.social_media_platform.repository.LikeRepository;
import com.example.social_media_platform.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public List<UserLike> findAll() {
        return likeRepository.findAll();
    }

    @Override
    public Optional<UserLike> findById(Long id) {
        return likeRepository.findById(id);
    }

    @Override
    public UserLike save(UserLike like) {
        return likeRepository.save(like);
    }

    @Override
    public void deleteById(Long id) {
        likeRepository.deleteById(id);
    }

    @Override
    public List<UserLike> findByUser(Long userId) {
        return likeRepository.findByUserId(userId); // Implement this using the repository
    }
}
*/
