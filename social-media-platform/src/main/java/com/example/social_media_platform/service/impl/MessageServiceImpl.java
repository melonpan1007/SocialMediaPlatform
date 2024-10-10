/*
package com.example.social_media_platform.service.impl;

import com.example.social_media_platform.model.Message;
import com.example.social_media_platform.repository.MessageRepository;
import com.example.social_media_platform.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message save(Message message) {
        if (message.getContent() == null || message.getContent().isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be empty");
        }
        // Optionally set a timestamp when saving a new message
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message update(Long id, Message newMessage) {
        return messageRepository.findById(id).map(existingMessage -> {
            existingMessage.setContent(newMessage.getContent());
            // Update the timestamp if necessary
            existingMessage.setTimestamp(LocalDateTime.now()); // or keep the existing timestamp
            return messageRepository.save(existingMessage);
        }).orElseThrow(() -> new IllegalArgumentException("Message not found with id: " + id));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!messageRepository.existsById(id)) {
            throw new IllegalArgumentException("Message not found with id: " + id);
        }
        messageRepository.deleteById(id);
    }
}
*/
