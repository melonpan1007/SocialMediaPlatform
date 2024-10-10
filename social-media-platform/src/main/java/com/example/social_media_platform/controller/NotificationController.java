/*package com.example.social_media_platform.controller;

import com.example.social_media_platform.datastructures.NotificationQueue;
import com.example.social_media_platform.model.Notification;
import com.example.social_media_platform.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationQueue notificationQueue;

    @Autowired
    public NotificationController(NotificationService notificationService, NotificationQueue notificationQueue) {
        this.notificationService = notificationService;
        this.notificationQueue = notificationQueue;
    }

    // Endpoint to create a notification
    @PostMapping("/create")
    public void createNotification(@RequestParam Long userId, @RequestParam String message) {
        notificationService.createNotification(userId, message);
        notificationQueue.enqueue(message);  // Enqueue the notification for additional processing
    }

    // Endpoint to get notifications for a user
    @GetMapping("/{userId}")
    public List<Notification> getUserNotifications(@PathVariable Long userId) {
        return notificationService.getUserNotifications(userId);
    }

    // Endpoint to mark a notification as read
    @PutMapping("/mark-read/{notificationId}")
    public void markAsRead(@PathVariable Long notificationId) {
        notificationService.markAsRead(notificationId);
    }

    // Endpoint to get all notifications from the queue (if needed)
    @GetMapping("/queue")
    public List<String> getAllQueueNotifications() {
        return notificationQueue.getAllNotifications();
    }
}
*/