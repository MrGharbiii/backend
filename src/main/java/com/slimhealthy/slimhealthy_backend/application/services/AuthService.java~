// src/main/java/com/slimhealthy/application/services/AuthService.java
package com.slimhealthy.slimhealthy_backend.application.services;

import com.slimhealthy.slimhealthy_backend.application.dto.LoginDto;
import com.slimhealthy.slimhealthy_backend.application.dto.UserRegistrationDto;
import com.slimhealthy.slimhealthy_backend.domain.model.aggregates.Mesures;
import com.slimhealthy.slimhealthy_backend.domain.model.entities.User;
import com.slimhealthy.slimhealthy_backend.domain.repositories.UserRepository;
import com.slimhealthy.slimhealthy_backend.security.jwt.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public String register(UserRegistrationDto dto) {
        if(userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        User user = User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .mesures(new Mesures()) // Initialize empty measurements
                .build();

        // Debug: Print before save
        System.out.println("Attempting to save user: " + user);

        User savedUser = userRepository.save(user);

        // Debug: Verify saved user
        System.out.println("Saved user with ID: " + savedUser.getId());
        System.out.println("User in DB: " +
                userRepository.findByEmail(savedUser.getEmail()).isPresent());

        return jwtUtil.generateToken(userDetailsService.loadUserByUsername(user.getEmail()));
    }

    public String login(LoginDto dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtil.generateToken((UserDetails) authentication.getPrincipal());
    }
}