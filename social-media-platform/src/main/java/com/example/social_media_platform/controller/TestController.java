package com.example.social_media_platform.controller;

import com.example.social_media_platform.dto.UserProfileDTO;
import com.example.social_media_platform.model.Role;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.service.RoleService;
import com.example.social_media_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> test(@RequestBody Map<String, Object> input) {
        return ResponseEntity.ok("Received: " + input.toString());
    }
}
