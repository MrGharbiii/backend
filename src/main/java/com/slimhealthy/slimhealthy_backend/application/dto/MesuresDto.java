package com.slimhealthy.slimhealthy_backend.application.dto;

import com.slimhealthy.slimhealthy_backend.domain.model.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class MesuresDto {
    @Min(12) @Max(120)
    private int age;

    private Gender gender;

    @Positive
    private double height;

    @Positive
    private double currentWeight;

    @Positive
    private double targetWeight;
}