// src/main/java/com/slimhealthy/application/controllers/AuthController.java
package com.slimhealthy.slimhealthy_backend.application.controllers;

import com.slimhealthy.slimhealthy_backend.application.dto.LoginDto;
import com.slimhealthy.slimhealthy_backend.application.dto.UserRegistrationDto;
import com.slimhealthy.slimhealthy_backend.application.services.AuthService;
import com.slimhealthy.slimhealthy_backend.security.jwt.JWTUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JWTUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody UserRegistrationDto dto)
    {
        String token = authService.register(dto);
        return ResponseEntity.ok(Map.of(
                "token", token,
                "message", "User registered successfully"
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @Valid @RequestBody LoginDto dto
    ) {
        String token = authService.login(dto);
        return ResponseEntity.ok(Map.of(
                "token", token,
                "message", "Login successful"
        ));
    }

    @GetMapping("/validate")
    public ResponseEntity<Map<String, Boolean>> validateToken(
            @RequestHeader("Authorization") String authHeader
    ) {
        String token = authHeader.substring(7); // Remove "Bearer "
        boolean isValid = jwtUtil.validateToken(token);
        return ResponseEntity.ok(Map.of("valid", isValid));
    }
}