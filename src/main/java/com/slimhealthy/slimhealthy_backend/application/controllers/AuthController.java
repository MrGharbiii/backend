// src/main/java/com/slimhealthy/application/controllers/AuthController.java
package com.slimhealthy.slimhealthy_backend.application.controllers;

import com.slimhealthy.slimhealthy_backend.application.dto.LoginDto;
import com.slimhealthy.slimhealthy_backend.application.dto.UserRegistrationDto;
import com.slimhealthy.slimhealthy_backend.application.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> register(@Valid @RequestBody UserRegistrationDto dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }
}