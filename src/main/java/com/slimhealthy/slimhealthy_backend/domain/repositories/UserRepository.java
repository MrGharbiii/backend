package com.slimhealthy.slimhealthy_backend.domain.repositories;

import com.slimhealthy.slimhealthy_backend.domain.model.entities.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
}