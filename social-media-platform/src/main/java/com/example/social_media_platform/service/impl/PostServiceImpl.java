package com.example.social_media_platform.service.impl;

import com.example.social_media_platform.model.Post;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.repository.PostRepository;
import com.example.social_media_platform.repository.UserRepository;
import com.example.social_media_platform.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository; // Inject UserRepository

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findByAuthor(Long userId) {
        // Fetch the user and handle the exception if not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        return postRepository.findByAuthor(user); // Call the repository method
    }

    @Override
    public List<Post> getTopPosts(int n) {
        PriorityQueue<Post> priorityQueue = new PriorityQueue<>(
                (p1, p2) -> Integer.compare(p2.getPopularityScore(), p1.getPopularityScore())
        );

        priorityQueue.addAll(findAll()); // Add all posts to the priority queue

        List<Post> topPosts = new ArrayList<>();
        for (int i = 0; i < n && !priorityQueue.isEmpty(); i++) {
            topPosts.add(priorityQueue.poll()); // Retrieve top posts
        }
        return topPosts;
    }
}
