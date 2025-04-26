package com.slimhealthy.slimhealthy_backend.domain.model.entities;

import com.slimhealthy.slimhealthy_backend.domain.model.aggregates.Mesures;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String uuid = UUID.randomUUID().toString();

    @Indexed(unique = true)
    private String email;

    private String password;

    private Mesures mesures;
}