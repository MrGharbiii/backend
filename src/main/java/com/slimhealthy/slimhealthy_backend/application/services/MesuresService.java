package com.slimhealthy.slimhealthy_backend.application.services;

import com.slimhealthy.slimhealthy_backend.application.dto.MesuresDto;
import com.slimhealthy.slimhealthy_backend.domain.model.aggregates.Mesures;
import com.slimhealthy.slimhealthy_backend.domain.model.entities.User;
import com.slimhealthy.slimhealthy_backend.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MesuresService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Mesures saveMesures(MesuresDto dto) {
        User user = getAuthenticatedUser();
        user.setMesures(modelMapper.map(dto, Mesures.class));
        return userRepository.save(user).getMesures();
    }

    public Mesures updateMesures(MesuresDto dto) {
        User user = getAuthenticatedUser();
        modelMapper.map(dto, user.getMesures());
        return userRepository.save(user).getMesures();
    }

    private User getAuthenticatedUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("Authenticated email from token: " + email); // Debug

        Optional<User> userOpt = userRepository.findByEmail(email);
        System.out.println("User found in DB: " + userOpt.isPresent()); // Debug

        return userOpt.orElseThrow(() -> {
            System.out.println("FAILURE: User not found for email: " + email); // Debug
            return new UsernameNotFoundException("User not found. Please register or login again.");
        });
    }
}