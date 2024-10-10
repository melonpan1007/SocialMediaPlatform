package com.example.social_media_platform.controller;

import com.example.social_media_platform.model.Role;
import com.example.social_media_platform.model.User;
import com.example.social_media_platform.service.RoleService;
import com.example.social_media_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleService.findById(id);
        return role.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        if (role.getRoleName() == null || role.getRoleName().isEmpty()) {
            throw new IllegalArgumentException("Role name cannot be null or empty");
        }
        Role savedRole = roleService.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Assign roles to a user
    @PostMapping("/assign/{userId}")
    public ResponseEntity<Void> assignRoles(@PathVariable Long userId, @RequestBody Set<Role> roles) {
        System.out.println("Assigning roles: " + roles + " to user ID: " + userId);
        userService.assignRoles(userId, roles);
        return ResponseEntity.ok().build();
    }

    // Remove role from a user
    @DeleteMapping("/remove/{userId}/{roleId}")
    public ResponseEntity<Void> removeRole(@PathVariable Long userId, @PathVariable Long roleId) {
        userService.removeRole(userId, roleId); // Use roleId instead of Role object
        return ResponseEntity.noContent().build();
    }
}
