package com.example.ai_career_guidance_backend.dto;

import com.example.ai_career_guidance_backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String message;
    private User user;
}


