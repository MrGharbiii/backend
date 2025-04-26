// src/test/java/com/slimhealthy/application/services/AuthServiceTest.java
package com.slimhealthy.slimhealthy_backend.application.services;

import com.slimhealthy.slimhealthy_backend.application.dto.UserRegistrationDto;
import com.slimhealthy.slimhealthy_backend.domain.model.entities.User;
import com.slimhealthy.slimhealthy_backend.domain.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {
    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @InjectMocks private AuthService authService;

    @Test
    void registerNewUserSuccessfully() {
        UserRegistrationDto dto = new UserRegistrationDto();
        dto.setEmail("test@example.com");
        dto.setPassword("password123");

        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(any())).thenReturn("hashedPassword");

        assertDoesNotThrow(() -> authService.register(dto));
        verify(userRepository).save(any(User.class));
    }
}