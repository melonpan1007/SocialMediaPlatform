/*
package com.example.social_media_platform.controller;

import com.example.social_media_platform.dto.MessageDto;
import com.example.social_media_platform.model.Message;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.service.MessageService;
import com.example.social_media_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;
    private final UserService userService;

    @Autowired
    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @PostMapping("/send")
    public ResponseEntity<Message> createMessage(@RequestBody MessageDto messageDto) {
        // Retrieve sender (user) by userId
        Optional<User> optionalSender = userService.findById(messageDto.getSenderId());
        if (optionalSender.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Sender not found
        }

        // Retrieve receiver (user) by userId
        Optional<User> optionalReceiver = userService.findById(messageDto.getReceiverId());
        if (optionalReceiver.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Receiver not found
        }

        // Create a new Message entity
        Message message = new Message();
        message.setContent(messageDto.getContent()); // Set the content from the DTO
        message.setSender(optionalSender.get()); // Set sender as User object
        message.setReceiver(optionalReceiver.get()); // Set receiver as User object
        message.setTimestamp(LocalDateTime.now());

        // Save the message using the service
        Message savedMessage = messageService.save(message);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedMessage); // Return 201 status
    }

}
*/
