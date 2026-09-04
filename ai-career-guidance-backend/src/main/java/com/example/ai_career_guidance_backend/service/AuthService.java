package com.example.ai_career_guidance_backend.service;

import com.example.ai_career_guidance_backend.dto.LoginRequest;
import com.example.ai_career_guidance_backend.model.User;
import com.example.ai_career_guidance_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User loginOrRegister(LoginRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setName(request.getName());
                    newUser.setEmail(request.getEmail());
                    newUser.setEducation("B.Tech 4th Year");
                    newUser.setSkills(Arrays.asList("React.js", "JavaScript", "Node.js"));
                    newUser.setInterests(Arrays.asList("Web Development", "Coding"));
                    return userRepository.save(newUser);
                });
    }

    public User getUserProfile(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }
}
