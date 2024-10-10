/*
package com.example.social_media_platform.controller;

import com.example.social_media_platform.dto.PhotoRequest;
import com.example.social_media_platform.model.Photo;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.repository.PhotoRepository;
import com.example.social_media_platform.repository.UserRepository;
import com.example.social_media_platform.service.PhotoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @GetMapping
    public List<Photo> getAllPhotos() {
        return photoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Photo> getPhotoById(@PathVariable Long id) {
        return photoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Photo> createPhoto(@RequestBody PhotoRequest request) {
        // Retrieve the user by ID
        User uploader = userRepository.findById(request.getUploaderId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Create a new Photo object and set the uploader
        Photo photo = new Photo();
        photo.setUrl(request.getUrl());
        photo.setUploader(uploader); // Set the User object

        // Save the photo using the uploader ID
        Photo savedPhoto = photoService.save(photo, uploader.getId());
        return ResponseEntity.ok(savedPhoto);
    }

    @DeleteMapping("/{id}")
    public void deletePhoto(@PathVariable Long id) {
        photoService.deleteById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Photo> getPhotosByUploader(@PathVariable Long userId) {
        return photoService.findByUploader(userId);
    }
}
*/
