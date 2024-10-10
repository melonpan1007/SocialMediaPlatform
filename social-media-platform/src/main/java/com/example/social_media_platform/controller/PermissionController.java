/*package com.example.social_media_platform.controller;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.model.Permission;
import com.example.social_media_platform.service.PermissionService;
import com.example.social_media_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @Autowired
    private UserService userService;

    @GetMapping
    public List<Permission> getAllPermissions() {
        return permissionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Permission> getPermissionById(@PathVariable Long id) {
        return permissionService.findById(id);
    }
    @PostMapping("/assign")
    public void assignPermissionToUser(@RequestParam Long userId, @RequestParam Long permissionId) {
        User user = userService.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Permission permission = permissionService.findById(permissionId).orElseThrow(() -> new IllegalArgumentException("Permission not found"));

        user.getPermissions().add(permission);
        userService.save(user);
    }

    @DeleteMapping("/remove")
    public void removePermissionFromUser(@RequestParam Long userId, @RequestParam Long permissionId) {
        User user = userService.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Permission permission = permissionService.findById(permissionId).orElseThrow(() -> new IllegalArgumentException("Permission not found"));

        user.getPermissions().remove(permission);
        userService.save(user);
    }
}


*/