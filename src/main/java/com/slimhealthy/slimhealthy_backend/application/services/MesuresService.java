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
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User not found. Please register or login again."
                ));
    }
}