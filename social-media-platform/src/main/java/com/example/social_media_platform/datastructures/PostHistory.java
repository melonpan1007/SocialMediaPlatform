/*
package com.example.social_media_platform.datastructures;

import com.example.social_media_platform.model.Post;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class PostHistory {
    private final Stack<Post> deletedPosts;

    public PostHistory() {
        this.deletedPosts = new Stack<>();
    }

    // Method to push a deleted post onto the stack
    public void push(Post post) {
        deletedPosts.push(post);
    }

    // Method to pop the last deleted post from the stack
    public Post pop() {
        if (!deletedPosts.isEmpty()) {
            return deletedPosts.pop();
        }
        return null;  // Return null if the stack is empty
    }
}
*/
