/*
package com.example.social_media_platform.datastructures;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
public class NotificationQueue {
    private final Queue<String> notifications;

    public NotificationQueue() {
        this.notifications = new LinkedList<>();
    }

    // Method to enqueue a notification
    public void enqueue(String notification) {
        notifications.add(notification);
    }

    // Method to dequeue a notification (optional, if you need to process notifications)
    public String dequeue() {
        return notifications.poll(); // Returns null if the queue is empty
    }

    // Method to get all notifications
    public List<String> getAllNotifications() {
        return new LinkedList<>(notifications);
    }

    // Optional: Method to check if the queue is empty
    public boolean isEmpty() {
        return notifications.isEmpty();
    }

    // Optional: Method to get the size of the notification queue
    public int size() {
        return notifications.size();
    }
}
*/
