// src/main/java/com/slimhealthy/application/services/AuthService.java
package com.slimhealthy.slimhealthy_backend.application.services;

import com.slimhealthy.slimhealthy_backend.application.dto.LoginDto;
import com.slimhealthy.slimhealthy_backend.application.dto.UserRegistrationDto;
import com.slimhealthy.slimhealthy_backend.domain.model.entities.User;
import com.slimhealthy.slimhealthy_backend.domain.repositories.UserRepository;
import com.slimhealthy.slimhealthy_backend.security.jwt.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public String register(UserRegistrationDto dto) {
        if(userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        userRepository.save(user);
        return jwtUtil.generateToken(user);
    }

    public String login(LoginDto dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtil.generateToken((User) authentication.getPrincipal());
    }
}