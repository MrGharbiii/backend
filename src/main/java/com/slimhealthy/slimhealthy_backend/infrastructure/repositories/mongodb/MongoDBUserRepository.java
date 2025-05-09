package com.slimhealthy.slimhealthy_backend.infrastructure.repositories.mongodb;

import com.slimhealthy.slimhealthy_backend.domain.model.entities.User;
import com.slimhealthy.slimhealthy_backend.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MongoDBUserRepository implements UserRepository {
    private final MongoTemplate mongoTemplate;

    @Override
    public Optional<User> findByEmail(String email) {
        User user = mongoTemplate.findOne(
                Query.query(Criteria.where("email").is(email)),
                User.class
        );
        return Optional.ofNullable(user); // Proper null handling
    }

    @Override
    public User save(User user) {
        return mongoTemplate.save(user);
    }
}