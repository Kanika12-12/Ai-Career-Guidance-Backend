package com.example.ai_career_guidance_backend.controller;

import com.example.ai_career_guidance_backend.dto.AuthResponse;
import com.example.ai_career_guidance_backend.dto.LoginRequest;
import com.example.ai_career_guidance_backend.model.User;
import com.example.ai_career_guidance_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        User user = authService.loginOrRegister(request);
        return ResponseEntity.ok(new AuthResponse("Login Successful", user));
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getProfile(@RequestParam String email) {
        User user = authService.getUserProfile(email);
        return ResponseEntity.ok(user);
    }
}