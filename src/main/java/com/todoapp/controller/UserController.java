package com.todoapp.controller;

import com.todoapp.model.User;
import com.todoapp.repository.UserRepository;
import com.todoapp.security.UserPrincipal;
import com.todoapp.dto.PasswordUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(@AuthenticationPrincipal UserPrincipal currentUser) {
        User user = userRepository.findById(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(null); // Don't send the password
        return ResponseEntity.ok(user);
    }

    @PutMapping("/me")
    public ResponseEntity<User> updateUser(
            @AuthenticationPrincipal UserPrincipal currentUser,
            @RequestBody User userUpdate) {
        User user = userRepository.findById(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstName(userUpdate.getFirstName());
        user.setLastName(userUpdate.getLastName());
        user.setProfilePicture(userUpdate.getProfilePicture());

        User updatedUser = userRepository.save(user);
        updatedUser.setPassword(null); // Don't send the password
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/me/password")
    public ResponseEntity<?> updatePassword(
            @AuthenticationPrincipal UserPrincipal currentUser,
            @RequestBody PasswordUpdateRequest passwordUpdate) {
        try {
            User user = userRepository.findById(currentUser.getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Validate new password
            if (passwordUpdate.getNewPassword() == null || passwordUpdate.getNewPassword().length() < 6) {
                return ResponseEntity.badRequest()
                    .body("New password must be at least 6 characters long");
            }

            // Update password
            user.setPassword(passwordEncoder.encode(passwordUpdate.getNewPassword()));
            userRepository.save(user);
            
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body("Failed to update password: " + e.getMessage());
        }
    }
} 