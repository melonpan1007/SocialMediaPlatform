/*
package com.example.social_media_platform.service.impl;

import com.example.social_media_platform.model.Photo;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.repository.PhotoRepository;
import com.example.social_media_platform.repository.UserRepository;
import com.example.social_media_platform.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private UserRepository userRepository; // Inject UserRepository

    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public Optional<Photo> findById(Long id) {
        return photoRepository.findById(id);
    }

    @Override
    public Photo save(Photo photo, Long uploaderId) {
        User user = userRepository.findById(uploaderId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        photo.setUploader(user); // Set the uploader before saving
        return photoRepository.save(photo);
    }

    @Override
    public void deleteById(Long id) {
        photoRepository.deleteById(id);
    }

    @Override
    public List<Photo> findByUploader(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return photoRepository.findByUploader(user); // Implement this method in the repository
    }
}
*/
